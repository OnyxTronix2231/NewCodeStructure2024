package frc.robot.subsystems.Elevator;

import com.ctre.phoenix.sensors.PigeonIMU;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

public interface ElevatorComponents {
    MotorController getLeftMasterMotor();
    MotorController getRightMasterMotor();

    PigeonIMU getGyro();

}
