package frc.robot.subsystem.elevator;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.PigeonIMU;

import static frc.robot.subsystem.elevator.Constants.ComponentsConstants.*;
import static frc.robot.subsystem.elevator.Constants.Configurations.*;

public class ElevatorComponentsImpl implements ElevatorComponents {

    private final WPI_TalonFX rightMaster;
    private final WPI_TalonFX rightMasterRightSlave;
    private final WPI_TalonFX rightMasterLeftSlave;
    private final WPI_TalonFX leftMaster;
    private final WPI_TalonFX leftMasterRightSlave;
    private final WPI_TalonFX leftMasterLeftSlave;
    private final PigeonIMU gyro;

    public ElevatorComponentsImpl() {
        rightMaster = new WPI_TalonFX(RIGHT_MASTER_ID);
        rightMaster.configFactoryDefault();
        rightMaster.configAllSettings(getConfig());
        rightMaster.setNeutralMode(NeutralMode.Brake);
        rightMasterLeftSlave = new WPI_TalonFX(RIGHT_MASTER_LEFT_SLAVE_ID);
        rightMasterLeftSlave.follow(rightMaster);
        rightMasterLeftSlave.setInverted(true);
        rightMasterRightSlave = new WPI_TalonFX(RIGHT_MASTER_RIGHT_SLAVE_ID);
        rightMasterRightSlave.follow(rightMaster);
        rightMasterRightSlave.setInverted(true);

        leftMaster = new WPI_TalonFX(LEFT_MASTER_ID);
        leftMaster.configFactoryDefault();
        leftMaster.configAllSettings(getConfig());
        leftMaster.setNeutralMode(NeutralMode.Brake);
        leftMasterLeftSlave = new WPI_TalonFX(LEFT_MASTER_LEFT_SLAVE_ID);
        leftMasterLeftSlave.follow(leftMaster);
        leftMasterLeftSlave.setInverted(true);
        leftMasterRightSlave = new WPI_TalonFX(LEFT_MASTER_RIGHT_SLAVE_ID);
        leftMasterRightSlave.follow(leftMaster);
        leftMasterRightSlave.setInverted(true);
        gyro = new PigeonIMU(GYRO_DEVICE_NUMBER);
    }

    @Override
    public WPI_TalonFX getRightMaster() {
        return rightMaster;
    }

    @Override
    public WPI_TalonFX getLeftMaster() {
        return leftMaster;
    }

    @Override
    public PigeonIMU getGyro() {
        return gyro;
    }

    private TalonFXConfiguration getConfig() {
        TalonFXConfiguration config = new TalonFXConfiguration();
        config.peakOutputForward = PEAK_OUTPUT_FORWARD;
        config.peakOutputReverse = PEAK_OUTPUT_REVERSE;
        config.openloopRamp = OPEN_LOOP_RAMP;
        return config;
    }
}
