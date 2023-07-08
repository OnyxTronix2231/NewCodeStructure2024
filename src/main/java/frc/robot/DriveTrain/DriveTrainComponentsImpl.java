package frc.robot.DriveTrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

public class DriveTrainComponentsImpl implements DriveTrainComponents {

    private final WPI_TalonFX leftMotor;

    private final WPI_TalonFX rightMotor;

    private final DifferentialDrive drive;



    public DriveTrainComponentsImpl() {
        leftMotor = new WPI_TalonFX(2);
        leftMotor.configFactoryDefault();

        rightMotor = new WPI_TalonFX(1);
        leftMotor.configFactoryDefault();

        drive = new DifferentialDrive(leftMotor, rightMotor);
        drive.setSafetyEnabled(true);



    }
    @Override
    public MotorController getLeftMotor() {
        return leftMotor;
    }

    @Override
    public MotorController getRightMotor() {
        return rightMotor;
    }

    @Override
    public DifferentialDrive getDrive() {
        return drive;
    }
}
