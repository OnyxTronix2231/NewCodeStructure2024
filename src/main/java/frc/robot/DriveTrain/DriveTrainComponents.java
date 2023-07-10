package frc.robot.DriveTrain;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

public interface DriveTrainComponents {
    public MotorController getLeftMotor();

    public MotorController getRightMotor();

    public DifferentialDrive getDrive();



}
