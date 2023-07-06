package frc.robot.subsystems.driveTrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

import static frc.robot.subsystems.driveTrain.DriveTrainConstants.ComponentsConstants.*;

public class DriveTrainComponentsImpl implements DriveTrainComponnents {
    private final WPI_TalonFX slaveLeft;
    private final WPI_TalonFX slaveRight;
    private final WPI_TalonFX masterLeft;
    private final WPI_TalonFX masterRight;
    private final DifferentialDrive differentialDrive;

    public DriveTrainComponentsImpl() {
        this.masterLeft = new WPI_TalonFX(MASTER_LEFT_ID);
        masterLeft.configFactoryDefault();

        this.masterRight = new WPI_TalonFX(MASTER_RIGHT_ID);
        masterRight.configFactoryDefault();

        this.slaveLeft = new WPI_TalonFX(SLAVE_LEFT_ID);
        slaveLeft.configFactoryDefault();
        slaveLeft.follow(masterLeft);

        this.slaveRight = new WPI_TalonFX(SLAVE_RIGHT_ID);
        slaveRight.configFactoryDefault();
        slaveRight.follow(masterRight);

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
