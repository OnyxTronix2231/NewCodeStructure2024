package frc.robot.subsystems.elevator;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.PigeonIMU;
import com.ctre.phoenix.sensors.WPI_Pigeon2;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

import static frc.robot.subsystems.elevator.ElevatorConstants.ComponentsConstants.*;

public class ElevatorComponentsImpl implements ElevatorComponents{
    private WPI_TalonFX leftMasterMotor;
    private WPI_TalonFX leftSlaveMotor1;
    private WPI_TalonFX leftSlaveMotor2;

    private WPI_TalonFX rightMasterMotor;
    private WPI_TalonFX rightSlaveMotor1;
    private WPI_TalonFX rightSlaveMotor2;

    private PigeonIMU pigeon2;

    public ElevatorComponentsImpl() {
        leftMasterMotor = new WPI_TalonFX(LEFT_MASTER_MOTOR_ID);
        leftMasterMotor.configFactoryDefault();
        leftMasterMotor.configAllSettings(getFalconConfiguration());
        leftMasterMotor.setNeutralMode(NeutralMode.Brake);

        leftSlaveMotor1 = new WPI_TalonFX(LEFT_SLAVE1_MOTOR_ID);
        leftSlaveMotor1.follow(leftMasterMotor);
        leftSlaveMotor1.configAllSettings(getFalconConfiguration());
        leftSlaveMotor1.setInverted(true);

        leftSlaveMotor2 = new WPI_TalonFX(LEFT_SLAVE2_MOTOR_ID);
        leftSlaveMotor2.follow(leftMasterMotor);
        leftSlaveMotor2.configAllSettings(getFalconConfiguration());
        leftSlaveMotor2.setInverted(true);

        rightMasterMotor = new WPI_TalonFX(RIGHT_MASTER_MOTOR_ID);
        rightMasterMotor.configFactoryDefault();
        rightMasterMotor.configAllSettings(getFalconConfiguration());
        rightMasterMotor.setNeutralMode(NeutralMode.Brake);

        rightSlaveMotor1 = new WPI_TalonFX(RIGHT_SLAVE1_MOTOR_ID);
        rightSlaveMotor1.follow(rightMasterMotor);
        rightSlaveMotor1.configAllSettings(getFalconConfiguration());
        rightSlaveMotor1.setInverted(true);

        rightSlaveMotor2 = new WPI_TalonFX(RIGHT_SLAVE2_MOTOR_ID);
        rightSlaveMotor2.follow(rightMasterMotor);
        rightSlaveMotor2.configAllSettings(getFalconConfiguration());
        rightSlaveMotor1.setInverted(true);

        pigeon2 = new PigeonIMU(PIGEON_ID);

    }

    @Override
    public MotorController getLeftMasterMotor() {
        return leftMasterMotor;
    }

    @Override
    public MotorController getRightMasterMotor() {
        return rightMasterMotor;
    }

    @Override
    public PigeonIMU getPigeon() {
        return pigeon2;
    }

    private TalonFXConfiguration getFalconConfiguration() {
        final TalonFXConfiguration config = new TalonFXConfiguration();
        config.peakOutputForward = PEAK_OUTPUT_FORWARD;
        config.peakOutputReverse = PEAK_OUTPUT_REVERSE;
        config.openloopRamp = OPEN_LOOP_RAMP;
        return config;
    }
}
