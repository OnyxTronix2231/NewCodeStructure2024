package frc.robot.subsystems.driveTrain.features;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.AbsoluteSensorRange;
import com.ctre.phoenix.sensors.CANCoderConfiguration;
import com.ctre.phoenix.sensors.SensorInitializationStrategy;
import com.ctre.phoenix.sensors.SensorTimeBase;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import pid.CtreMotionMagicController;
import pid.CtrePIDController;
import pid.PIDControlMode;
import pid.interfaces.PIDController;
import sensors.counter.CtreCANCoder;
import sensors.counter.CtreEncoder;
import sensors.counter.TalonEncoder;

import static frc.robot.subsystems.driveTrain.DriveTrainConstants.*;

public class SwerveModule {
    private final WPI_TalonFX driveMotor;
    private final WPI_TalonFX turningMotor;
    private final CtreCANCoder absoluteEncoder;
    private final CtreMotionMagicController turningController;
    private final PIDController driveController;

    public double getAngleOffset() {
        return angleOffset;
    }

    private final double angleOffset;

    public SwerveModule(int driverID, int turningId, int encoderID, double angleOffset) {
        driveMotor = new WPI_TalonFX(driverID);
        driveMotor.configAllSettings(swerveDriveFXConfig());

        turningMotor = new WPI_TalonFX(turningId);
        turningMotor.configAllSettings(swerveRotationFXConfig());

        absoluteEncoder = new CtreCANCoder(encoderID);
        absoluteEncoder.configAllSettings(swerveCANCoderConfig());

        CtreEncoder turningEncoder = new TalonEncoder(turningMotor);
        turningController = new CtreMotionMagicController(
                turningMotor,
                turningEncoder,
                TURNING_MOTOR_PID,
                TURNING_MOTOR_ACC,
                TURNING_MOTOR_CRUISE_VEL,
                TURNING_MOTOR_ACC_SMOOTHING
        );

        CtreEncoder driverEncoder = new TalonEncoder(driveMotor);
        driveController = new CtrePIDController(
                driveMotor,
                driverEncoder,
                DRIVE_MOTOR_PID,
                PIDControlMode.Velocity
        );
        this.angleOffset = angleOffset;
    }

    public void resetToAbsolute() {
        double absPosDeg = getAbsEncDeg() - angleOffset;
        double absPosEnc = degreesToEnc(absPosDeg);
        turningMotor.setSelectedSensorPosition(absPosEnc);
    }

    public void initSwerveModule(SwerveModuleState targetModuleState) {
        targetModuleState = optimize(targetModuleState, getCurrentRelativeDeg());
        turningController.setSetpoint(degreesToEnc(targetModuleState.angle.getDegrees()));
        turningController.enable();

        double angleError = Math.toRadians(encToDegrees(turningController.getCurrentError()));
        driveController.setSetpoint(mpsToEpd(targetModuleState.speedMetersPerSecond * Math.cos(angleError)));
        driveController.enable();
    }

    public void updateSwerveModule(SwerveModuleState targetModuleState) {
        targetModuleState = optimize(targetModuleState, getCurrentRelativeDeg());
        turningController.update(degreesToEnc(targetModuleState.angle.getDegrees()));

        double angleError = Math.toRadians(encToDegrees(turningController.getCurrentError()));
        System.out.println(targetModuleState.speedMetersPerSecond * Math.cos(angleError));
        driveController.update(mpsToEpd(targetModuleState.speedMetersPerSecond * Math.cos(angleError)));
    }

    public void disableModule() {
        turningController.disable();
        driveController.disable();
    }

    public void moduleCoast() {
        driveMotor.setNeutralMode(NeutralMode.Coast);
        turningMotor.setNeutralMode(NeutralMode.Coast);
    }

    public void moduleBrake() {
        driveMotor.setNeutralMode(NeutralMode.Brake);
        turningMotor.setNeutralMode(NeutralMode.Brake);
    }

    private static TalonFXConfiguration swerveDriveFXConfig() {
        TalonFXConfiguration config = new TalonFXConfiguration();
        config.initializationStrategy = SensorInitializationStrategy.BootToZero;
//        config.supplyCurrLimit = DRIVING_MOTOR_CURRENT_LIMIT;
        return config;
    }

    private static TalonFXConfiguration swerveRotationFXConfig() {
        TalonFXConfiguration config = new TalonFXConfiguration();
        config.initializationStrategy = SensorInitializationStrategy.BootToZero;
        // config.slot0.allowableClosedloopError = 0.0;
        // config.supplyCurrLimit = TURNING_MOTOR_CURRENT_LIMIT;
        // config.slot0.integralZone = 50;
        return config;
    }

    private static CANCoderConfiguration swerveCANCoderConfig() {
        CANCoderConfiguration config = new CANCoderConfiguration();
        config.absoluteSensorRange = AbsoluteSensorRange.Unsigned_0_to_360;
        config.sensorDirection = true;
        config.initializationStrategy = SensorInitializationStrategy.BootToAbsolutePosition;
        config.sensorTimeBase = SensorTimeBase.PerSecond;
        return config;
    }

    public double getCurrentRelativeDeg() {
        return encToDegrees(turningMotor.getSelectedSensorPosition());
    }

    public double getCurrentAbsoluteDeg() {
        return ((getCurrentRelativeDeg() % 360) + 360) % 360;
    }

    public double getCurrentSpeed() {
        return epdToMps(driveMotor.getSelectedSensorVelocity());
    }

    public double getAbsEncDeg() {
        return absoluteEncoder.getAbsolutePosition();
    }

    public SwerveModuleState getState() {
        return new SwerveModuleState(getCurrentSpeed(), Rotation2d.fromDegrees(getCurrentAbsoluteDeg()));
    }

    public SwerveModulePosition getPosition() {
        return new SwerveModulePosition(EncToMeters(driveMotor.getSelectedSensorPosition()),
                Rotation2d.fromDegrees(getCurrentRelativeDeg()));
    }
}
