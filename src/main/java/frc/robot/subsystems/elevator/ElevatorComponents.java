package frc.robot.subsystems.elevator;

import com.ctre.phoenix.sensors.BasePigeon;
import com.ctre.phoenix.sensors.PigeonIMU;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

public interface ElevatorComponents {

    MotorController getLeftMasterMotor();

    MotorController getRightMasterMotor();

    PigeonIMU getGyro();
}
