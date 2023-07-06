package frc.robot.subsystems.driveTrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

import static frc.robot.subsystems.driveTrain.DriveTrainConstants.ComponentsConstants.*;

public class DriveTrainComponentsImpl implements DriveTrainComponents {
    private WPI_TalonFX rightMotor;
    private WPI_TalonFX rightSlave;
    private WPI_TalonFX leftMotor;
    private WPI_TalonFX leftSlave;
    private DifferentialDrive differentialDrive;

    public DriveTrainComponentsImpl() {
        rightMotor = new WPI_TalonFX(RIGHT_Motor_PORT);
        rightMotor.configFactoryDefault();

        rightSlave = new WPI_TalonFX(RIGHT_SLAVE_Motor_PORT);
        rightSlave.configFactoryDefault();
        rightSlave.follow(rightMotor);

        leftMotor = new WPI_TalonFX(LEFT_Motor_PORT);
        leftMotor.configFactoryDefault();

        leftSlave = new WPI_TalonFX(LEFT_SALVE_Motor_PORT);
        leftSlave.configFactoryDefault();
        leftSlave.follow(leftMotor);

        differentialDrive = new DifferentialDrive(leftMotor, rightMotor);
        differentialDrive.setSafetyEnabled(true);
    }

    @Override
    public MotorController getLeftMotor() {
        return leftMotor;
    }

    @Override
    public WPI_TalonFX getRightMotor() {
        return rightMotor;
    }

    public DifferentialDrive getDifferentialDrive() {
        return differentialDrive;
    }
}
