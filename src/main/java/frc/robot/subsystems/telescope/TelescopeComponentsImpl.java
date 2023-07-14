package frc.robot.subsystems.telescope;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import pid.CtreMotionMagicController;
import pid.CtrePIDController;
import pid.PIDControlMode;
import pid.PIDFTerms;
import sensors.counter.Counter;
import sensors.counter.TalonEncoder;

import static frc.robot.subsystems.telescope.TelescopeConstants.Calculations.*;
import static frc.robot.subsystems.telescope.TelescopeConstants.ComponentsConstants.*;
import static frc.robot.subsystems.telescope.TelescopeConstants.TELESCOPE_PID.*;

public class TelescopeComponentsImpl implements TelescopeComponents{
    private final WPI_TalonFX telescopeMotor;
    private TalonEncoder talonEncoder;
    private final CtreMotionMagicController positionController;
    private final CtrePIDController velocityController;

    public TelescopeComponentsImpl() {
        telescopeMotor = new WPI_TalonFX(MOTOR_ID);
        telescopeMotor.configFactoryDefault();
        telescopeMotor.configAllSettings(getTalonFXConfiguration());
        telescopeMotor.config_IntegralZone(0,lengthToEncoderUnits(5, 0),0);
        telescopeMotor.setSelectedSensorPosition(0);
        telescopeMotor.setNeutralMode(NeutralMode.Brake);

        talonEncoder = new TalonEncoder(telescopeMotor);

        positionController = new CtreMotionMagicController(telescopeMotor, talonEncoder,
                POSITION_CONTROLLER, ACCELERATION, CRUISE_VELOCITY, ACC_SMOOTHING);
        velocityController = new CtrePIDController(telescopeMotor, talonEncoder,
                new PIDFTerms(KP, KI, KD, KF), PIDControlMode.Velocity);
    }
    @Override
    public MotorController getMotor() {
        return telescopeMotor;
    }

    @Override
    public Counter getEncoder() {
        return talonEncoder;
    }

    @Override
    public CtrePIDController getVelocityController() {
        return velocityController;
    }

    @Override
    public CtreMotionMagicController getPositionController() {
        return positionController;
    }

    public TalonFXConfiguration getTalonFXConfiguration() {
        TalonFXConfiguration config = new TalonFXConfiguration();
        config.forwardSoftLimitThreshold = lengthToEncoderUnits(MAX_LEN, 0);
        config.forwardSoftLimitEnable = false;
        config.reverseSoftLimitThreshold = lengthToEncoderUnits(MIN_LEN, 0);
        config.reverseSoftLimitEnable = false;
        return config;
    }

}
