package frc.robot.subsystems.driveTrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

import static frc.robot.subsystems.driveTrain.DriveTrainConstants.ComponentsConstants.*;

public class DriveTrainComponentsImpl implements DriveTrainComponnents {
    private final WPI_TalonSRX masterLeft;
    private final WPI_TalonSRX masterRight;
    private final WPI_VictorSPX slaveLeft;
    private final WPI_VictorSPX slaveRight;
    private final WPI_VictorSPX secondSlaveLeft;
    private final WPI_VictorSPX secondSlaveRight;
    private final DifferentialDrive differentialDrive;

    public DriveTrainComponentsImpl() {
        this.masterLeft = new WPI_TalonSRX(MASTER_LEFT_ID);
        masterLeft.configFactoryDefault();

        this.masterRight = new WPI_TalonSRX(MASTER_RIGHT_ID);
        masterRight.configFactoryDefault();
        masterRight.setInverted(true);

        this.slaveLeft = new WPI_VictorSPX(SLAVE_LEFT_ID);
        slaveLeft.configFactoryDefault();
        slaveLeft.follow(masterLeft);

        this.slaveRight = new WPI_VictorSPX(SLAVE_RIGHT_ID);
        slaveRight.configFactoryDefault();
        slaveRight.follow(masterRight);
        slaveRight.setInverted(true);

        this.secondSlaveLeft = new WPI_VictorSPX(5);
        secondSlaveLeft.configFactoryDefault();
        secondSlaveLeft.follow(masterLeft);

        this.secondSlaveRight = new WPI_VictorSPX(6);
        secondSlaveRight.configFactoryDefault();
        secondSlaveRight.follow(masterRight);
        secondSlaveRight.setInverted(true);
        this.differentialDrive = new DifferentialDrive(masterLeft, masterRight);
        differentialDrive.setSafetyEnabled(true);
    }

    @Override
    public MotorController getMasterLeft() {
        return masterLeft;
    }

    @Override
    public MotorController getMasterRight() {
        return masterRight;
    }

    @Override
    public DifferentialDrive getDifferentialDrive() {
        return differentialDrive;
    }
}
