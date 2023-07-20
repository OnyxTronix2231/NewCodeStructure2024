package frc.robot.subsystems.tankDriveTrain;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

public interface TankComponents {
    MotorController getRightMasterMotor();

    MotorController getLeftMasterMotor();

    DifferentialDrive getDifferentialDrive();



}
