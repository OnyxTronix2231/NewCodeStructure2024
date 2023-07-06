package frc.robot.subsystems.driveTrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import static frc.robot.subsystems.driveTrain.DriveTrainConstants.ComponentsConstants.*;

public class DriveTrainComponentsImpl implements DriveTrainComponents{

    private final WPI_TalonFX leftMasterMotor;
    private final WPI_TalonFX leftSlaveMotor;
    private final WPI_TalonFX rightMasterMotor;
    private final WPI_TalonFX rightSlaveMotor;

    private final DifferentialDrive differentialDrive;
    public DriveTrainComponentsImpl(){
        leftMasterMotor = new WPI_TalonFX(LEFT_MASTER_MOTOR_PORT);
        leftMasterMotor.configFactoryDefault();

        leftSlaveMotor = new WPI_TalonFX(LEFT_SLAVE_MOTOR_PORT);
        leftSlaveMotor.follow(leftMasterMotor);

        rightMasterMotor = new WPI_TalonFX(RIGHT_MASTER_MOTOR_PORT);
        rightMasterMotor.configFactoryDefault();

        rightSlaveMotor = new WPI_TalonFX(RIGHT_SLAVE_MOTOR_PORT);
        rightSlaveMotor.follow(rightMasterMotor);

        differentialDrive = new DifferentialDrive(leftMasterMotor,rightMasterMotor);
        differentialDrive.setSafetyEnabled(true);
    }
    @Override
    public MotorController getLeftMotor() {
        return this.leftMasterMotor;
    }

    @Override
    public MotorController getRightMotor() {
        return this.rightMasterMotor;
    }

    @Override
    public DifferentialDrive getDifferentialDrive() {
        return this.differentialDrive;
    }
}
