package frc.robot.subsystems.driveTrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import static frc.robot.subsystems.driveTrain.DriveTrainConstants.ComponentsConstants.*;

public class DriveTrainComponentsImpl implements DriveTrainComponents {
    private final WPI_TalonFX leftMasterMotor;
    private final WPI_TalonFX rightMasterMotor;
    private final WPI_TalonFX leftSlaveMotor;
    private final WPI_TalonFX rightSlaveMotor;
    private final DifferentialDrive differentialDrive;

    public DriveTrainComponentsImpl() {
        leftMasterMotor = new WPI_TalonFX(RIGHT_MASTER_MOTOR_PORT);
        leftMasterMotor.configFactoryDefault();

        leftSlaveMotor = new WPI_TalonFX(RIGHT_SLAVE_MOTOR_PORT);
        leftSlaveMotor.follow(getRightMasterMotor());

        rightMasterMotor = new WPI_TalonFX(LEFT_MASTER_MOTOR_PORT);
        rightMasterMotor.configFactoryDefault();

        rightSlaveMotor = new WPI_TalonFX(LEFT_SLAVE_MOTOR_PORT);
        rightSlaveMotor.follow(getLeftMasterMotor());

        differentialDrive = new DifferentialDrive(leftMasterMotor, rightMasterMotor);
        differentialDrive.setSafetyEnabled(true);
    }

    @Override
    public WPI_TalonFX getLeftMasterMotor() {
        return leftMasterMotor;
    }

    @Override
    public WPI_TalonFX getRightMasterMotor() {
        return rightMasterMotor;
    }

    @Override
    public DifferentialDrive getDifferentialDrive() {
        return differentialDrive;
    }

}
