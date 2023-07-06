package frc.robot.subsystems.elevator;

import com.ctre.phoenix.sensors.BasePigeon;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

public interface ElevatorComponents {

    MotorController getLeftMasterMotor();

    MotorController getRightMasterMotor();

    BasePigeon getGyro();
}
