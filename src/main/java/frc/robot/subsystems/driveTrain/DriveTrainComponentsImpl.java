package frc.robot.subsystems.driveTrain;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import static frc.robot.subsystems.driveTrain.DriveTrainConstants.ComponentsConstants.*;

public class DriveTrainComponentsImpl implements DriveTrainComponents {
    private final WPI_TalonFX leftMasterMotor;
    private final WPI_TalonFX leftSlaveMotor;
    private final WPI_TalonFX rightMasterMotor;
    private final WPI_TalonFX rightSlaveMotor;
    private final DifferentialDrive differentialDrive;

    public DriveTrainComponentsImpl() {
        leftMasterMotor = new WPI_TalonFX(RIGHT_MASTER_MOTOR_PORT);
        leftMasterMotor.configFactoryDefault();
        leftMasterMotor.configAllSettings(getFalconConfiguration());
        leftMasterMotor.setNeutralMode(NeutralMode.Brake);

        leftSlaveMotor = new WPI_TalonFX(RIGHT_SLAVE_MOTOR_PORT);
        leftSlaveMotor.follow(leftMasterMotor);
        leftSlaveMotor.configAllSettings(getFalconConfiguration());
        leftSlaveMotor.setNeutralMode(NeutralMode.Brake);
        leftSlaveMotor.follow(leftMasterMotor);

        rightMasterMotor = new WPI_TalonFX(LEFT_MASTER_MOTOR_PORT);
        rightMasterMotor.configFactoryDefault();
        rightMasterMotor.configAllSettings(getFalconConfiguration());
        rightMasterMotor.setInverted(true);
        rightMasterMotor.setNeutralMode(NeutralMode.Brake);

        rightSlaveMotor = new WPI_TalonFX(LEFT_SLAVE_MOTOR_PORT);
        rightSlaveMotor.follow(rightMasterMotor);
        rightSlaveMotor.configAllSettings(getFalconConfiguration());
        rightSlaveMotor.setInverted(true);
        rightSlaveMotor.setNeutralMode(NeutralMode.Brake);
        rightSlaveMotor.follow(rightMasterMotor);

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

    private TalonFXConfiguration getFalconConfiguration() {
        final TalonFXConfiguration config = new TalonFXConfiguration();
        return config;
    }
}
