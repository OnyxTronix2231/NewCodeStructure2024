package frc.robot.subsystems.Elevator;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.PigeonIMU;
import frc.robot.subsystems.Elevator.ElevatorConstants.ComponentsConstants.*;

import static frc.robot.subsystems.Elevator.ElevatorConstants.ComponentsConstants.*;

public class ElevatorComponnentsImpl implements ElevatorComponents {
    private final WPI_TalonFX leftMaster;
    private final WPI_TalonFX firstLeftSlave;
    private final WPI_TalonFX secondLeftSlave;

    private final WPI_TalonFX rightMaster;
    private final WPI_TalonFX firstRightSlave;
    private final WPI_TalonFX secondRightSlave;

    private final PigeonIMU gyro;

    public ElevatorComponnentsImpl() {
        this.leftMaster = new WPI_TalonFX(MASTER_LEFT_PORT_ID);
        leftMaster.configAllSettings(getFalconConfiguration());
        leftMaster.setNeutralMode(NeutralMode.Brake);

        this.firstLeftSlave = new WPI_TalonFX(SLAVE_FIRST_LEFT_PORT_ID);
        firstLeftSlave.follow(leftMaster);
        firstLeftSlave.configAllSettings(getFalconConfiguration());
        firstLeftSlave.setInverted(true);

        this.secondLeftSlave = new WPI_TalonFX(SLAVE_FIRST_LEFT_PORT_ID);
        secondLeftSlave.follow(leftMaster);
        secondLeftSlave.configAllSettings(getFalconConfiguration());
        secondLeftSlave.setInverted(true);

        this.rightMaster = new WPI_TalonFX(MASTER_RIGHT_PORT_ID);
        rightMaster.configAllSettings(getFalconConfiguration());
        rightMaster.setNeutralMode(NeutralMode.Brake);

        this.firstRightSlave = new WPI_TalonFX(SLAVE_FIRST_RIGHT_PORT_ID);
        firstRightSlave.follow(rightMaster);
        firstRightSlave.setInverted(true);
        firstRightSlave.configAllSettings(getFalconConfiguration());

        this.secondRightSlave = new WPI_TalonFX(SLAVE_SECOND_RIGHT_PORT_ID);
        secondRightSlave.follow(rightMaster);
        secondRightSlave.setInverted(true);
        secondRightSlave.configAllSettings(getFalconConfiguration());

        this.gyro = new PigeonIMU(GYRO_PORT_ID);
    }

    @Override
    public WPI_TalonFX getElevatorLeftMaster() {
        return leftMaster;
    }

    @Override
    public WPI_TalonFX getElevatorRightMaster() {
        return rightMaster;
    }

    @Override
    public PigeonIMU getGyro() {
        return gyro;
    }
    private TalonFXConfiguration getFalconConfiguration() {
        TalonFXConfiguration config = new TalonFXConfiguration();
        config.peakOutputForward = PEAK_OUTPUT_FORWARD;
        config.peakOutputReverse = PEAK_OUTPUT_REVERSE;
        config.openloopRamp = OPEN_LOOP_RAMP;
        return config;
    }


}
