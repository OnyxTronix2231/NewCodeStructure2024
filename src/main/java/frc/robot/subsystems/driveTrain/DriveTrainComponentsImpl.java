package frc.robot.subsystems.driveTrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import static frc.robot.subsystems.driveTrain.DriveTrainConstants.ComponentsConstants.*;

public class DriveTrainComponentsImpl implements DriveTrainComponents {

    private final WPI_TalonFX LeftMasterMotor;
    private final WPI_TalonFX RightMasterMotor;
    private final WPI_TalonFX LeftSlaveMotor;
    private final WPI_TalonFX RightSlaveMotor;

    private final DifferentialDrive differentialDrive;

    public DriveTrainComponentsImpl() {
        RightMasterMotor = new WPI_TalonFX(RIGHT_MASTER_MOTOR_PORT);
        RightMasterMotor.configFactoryDefault();

        LeftMasterMotor = new WPI_TalonFX(LEFT_MASTER_MOTOR_PORT);
        LeftMasterMotor.configFactoryDefault();

        RightSlaveMotor = new WPI_TalonFX(RIGHT_SLAVE_MOTOR_PORT);
        LeftSlaveMotor = new WPI_TalonFX(LEFT_SLAVE_MOTOR_PORT);

        LeftSlaveMotor.follow(LeftMasterMotor);
        RightSlaveMotor.follow(RightMasterMotor);

        differentialDrive = new DifferentialDrive(LeftMasterMotor, RightMasterMotor);
        differentialDrive.setSafetyEnabled(true);
    }

    @Override
    public WPI_TalonFX getLeftMasterMotor() {
        return LeftMasterMotor;
    }

    @Override
    public WPI_TalonFX getRightMasterMotor() {
        return RightMasterMotor;
    }

    @Override
    public DifferentialDrive getDifferentialDrive() {
        return differentialDrive;
    }
}
