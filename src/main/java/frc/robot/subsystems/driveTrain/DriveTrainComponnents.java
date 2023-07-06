package frc.robot.subsystems.driveTrain;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

public interface DriveTrainComponnents {
    MotorController getMasterLeft();

    MotorController getMasterRight();

    DifferentialDrive getDifferentialDrive();
}
