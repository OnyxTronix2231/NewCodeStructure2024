package frc.robot.subsystems.Elevator;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.PigeonIMU;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

import static frc.robot.subsystems.Elevator.ElevatorConstats.*;


public class ElevatorComponentsImpl implements ElevatorComponents{

    private final WPI_TalonFX leftMasterMotor;
    private final WPI_TalonFX rightMasterMotor;

    private final WPI_TalonFX leftSlaveMotor1;
    private final WPI_TalonFX leftSlaveMotor2;

    private final WPI_TalonFX rightSlaveMotor1;
    private final WPI_TalonFX rightSlaveMotor2;

    private PigeonIMU pigeonIMU;


    public ElevatorComponentsImpl() {
        rightMasterMotor = new WPI_TalonFX(RIGHT_MASTER_MOTOR_PORT);
        rightMasterMotor.configAllSettings(getFalconConfiguration());
        rightMasterMotor.setNeutralMode(NeutralMode.Brake);

        leftMasterMotor = new WPI_TalonFX(LEFT_MASTER_MOTOR_PORT);
        leftMasterMotor.configAllSettings(getFalconConfiguration());
        leftMasterMotor.setNeutralMode(NeutralMode.Brake);


        rightSlaveMotor1 = new WPI_TalonFX(RIGHT_SLAVE_MOTOR_1_PORT);
        rightSlaveMotor1.follow(rightMasterMotor);
        rightSlaveMotor1.configAllSettings(getFalconConfiguration());
        rightSlaveMotor1.setInverted(true);

        rightSlaveMotor2 = new WPI_TalonFX(RIGHT_SLAVE_MOTOR_2_PORT);
        rightSlaveMotor2.follow(rightMasterMotor);
        rightSlaveMotor2.configAllSettings(getFalconConfiguration());
        rightSlaveMotor2.setInverted(true);


        leftSlaveMotor1 = new WPI_TalonFX(LEFT_SLAVE_MOTOR_1_PORT);
        leftSlaveMotor1.follow(leftMasterMotor);
        leftSlaveMotor1.configAllSettings(getFalconConfiguration());
        leftSlaveMotor1.setInverted(true);

        leftSlaveMotor2 = new WPI_TalonFX(LEFT_SLAVE_MOTOR_2_PORT);
        leftSlaveMotor2.follow(leftMasterMotor);
        leftSlaveMotor2.configAllSettings(getFalconConfiguration());
        leftSlaveMotor2.setInverted(true);

        pigeonIMU = new PigeonIMU(PIGEON_IMU_DEV_NUM);
        pigeonIMU.configFactoryDefault();
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
    public PigeonIMU getGyro() {
        return pigeonIMU;
    }

    public TalonFXConfiguration getFalconConfiguration(){
        final TalonFXConfiguration config = new TalonFXConfiguration();
        config.peakOutputForward = PEAK_OUTPUT_FORWARD;
        config.peakOutputReverse = PEAK_OUTPUT_REVERSE;
        config.openloopRamp = OPEN_LOOP_RAMP;
        return config;
    }

}
