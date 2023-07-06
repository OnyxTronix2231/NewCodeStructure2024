package frc.robot.subsystems.elevator;

import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.sensors.PigeonIMU;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

public interface ElevatorComponents {
    MotorController getRightMasterMotor();
    MotorController getLeftMasterMotor();
    PigeonIMU getGyro();
}
