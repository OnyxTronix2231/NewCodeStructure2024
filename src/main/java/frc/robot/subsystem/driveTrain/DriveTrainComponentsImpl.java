package frc.robot.subsystem.driveTrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

import static frc.robot.subsystem.driveTrain.Constants.ComponentsConstants.*;

public class DriveTrainComponentsImpl implements DriveTrainComponents {

    private final WPI_TalonFX rightMotor;
    private final WPI_TalonFX rightSlaveMotor;
    private final WPI_TalonFX leftMotor;
    private final WPI_TalonFX leftSlaveMotor;
    private final DifferentialDrive differentialDrive;

    public DriveTrainComponentsImpl() {
        rightMotor = new WPI_TalonFX(RIGHT_MOTOR_ID);
        rightMotor.configFactoryDefault();
        rightSlaveMotor = new WPI_TalonFX(RIGHT_SLAVE_MOTOR_ID);
        rightSlaveMotor.follow(rightMotor);
        leftMotor = new WPI_TalonFX(LEFT_MOTOR_ID);
        leftMotor.configFactoryDefault();
        leftSlaveMotor = new WPI_TalonFX(LEFT_SLAVE_MOTOR_ID);
        leftSlaveMotor.follow(leftMotor);
        differentialDrive = new DifferentialDrive(leftMotor, rightMotor);
        differentialDrive.setSafetyEnabled(true);
    }

    @Override
    public MotorController getRightMotor() {
        return rightMotor;
    }

    @Override
    public MotorController getLeftMotor() {
        return leftMotor;
    }

    @Override
    public DifferentialDrive getDifferentialDrive() {
        return differentialDrive;
    }
}
