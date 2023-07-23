package frc.robot.subsystems.tankDriveTrain;

import com.ctre.phoenix.sensors.WPI_PigeonIMU;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

public interface TankComponents {
    MotorController getRightMasterMotor();

    MotorController getLeftMasterMotor();

    WPI_PigeonIMU getPigeon();

    DifferentialDrive getDifferentialDrive();





}
