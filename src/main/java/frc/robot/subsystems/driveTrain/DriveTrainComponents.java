package frc.robot.subsystems.driveTrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public interface DriveTrainComponents {

    WPI_TalonFX getLeftMasterMotor();

    WPI_TalonFX getRightMasterMotor();

    DifferentialDrive getDifferentialDrive();
}
