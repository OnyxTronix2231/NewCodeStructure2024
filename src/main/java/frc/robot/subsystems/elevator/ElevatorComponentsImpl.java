package frc.robot.subsystems.elevator;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.BasePigeon;
import com.ctre.phoenix.sensors.PigeonIMU;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

import static frc.robot.subsystems.elevator.ElevatorConstants.ComponentsConstants.*;

public class ElevatorComponentsImpl implements ElevatorComponents {

    private final WPI_TalonFX leftMasterMotor;
    private final WPI_TalonFX leftFirstSlaveMotor;
    private final WPI_TalonFX leftSecondSlaveMotor;
    private final WPI_TalonFX rightMasterMotor;
    private final WPI_TalonFX rightFirstSlaveMotor;
    private final WPI_TalonFX rightSecondSlaveMotor;

    private final PigeonIMU gyro;

    public ElevatorComponentsImpl() {
        leftMasterMotor = new WPI_TalonFX(LEFT_MASTER_MOTOR_PORT);
        leftMasterMotor.configFactoryDefault();
        leftMasterMotor.setNeutralMode(NeutralMode.Brake);

        leftFirstSlaveMotor = new WPI_TalonFX(LEFT_FIRST_SLAVE_MOTOR_PORT);
        leftFirstSlaveMotor.follow(leftMasterMotor);
        leftFirstSlaveMotor.setInverted(true);

        leftSecondSlaveMotor = new WPI_TalonFX(LEFT_SECOND_SLAVE__MOTOR_PORT);
        leftSecondSlaveMotor.follow(leftMasterMotor);
        leftSecondSlaveMotor.setInverted(true);

        rightMasterMotor = new WPI_TalonFX(RIGHT_MASTER_MOTOR_PORT);
        rightMasterMotor.configFactoryDefault();
        rightMasterMotor.setNeutralMode(NeutralMode.Brake);

        rightFirstSlaveMotor = new WPI_TalonFX(RIGHT_FIRST_SLAVE_MOTOR_PORT);
        rightFirstSlaveMotor.follow(rightMasterMotor);
        rightFirstSlaveMotor.setInverted(true);

        rightSecondSlaveMotor = new WPI_TalonFX(RIGHT_SECOND_SLAVE_MOTOR_PORT);
        rightSecondSlaveMotor.follow(rightMasterMotor);
        rightSecondSlaveMotor.setInverted(true);

        gyro = new PigeonIMU(LEFT_MASTER_MOTOR_PORT);

    }

    public TalonFXConfiguration getFalconConfiguration() {
        TalonFXConfiguration nig = new TalonFXConfiguration();
        nig.peakOutputForward = PEAK_OUTPUT_FORWARD;
        nig.peakOutputReverse = PEAK_OUTPUT_REVERSE;
        nig.openloopRamp = OPEN_LOOP_RAMP;
        return nig;
    }

    @Override
    public MotorController getLeftMasterMotor() {
        return this.leftMasterMotor;
    }

    @Override
    public MotorController getRightMasterMotor() {
        return this.rightMasterMotor;
    }

    @Override
    public BasePigeon getGyro() {
        return this.gyro;
    }
}
