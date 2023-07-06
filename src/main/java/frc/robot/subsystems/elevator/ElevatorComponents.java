package frc.robot.subsystems.elevator;

import com.ctre.phoenix.sensors.PigeonIMU;
import com.ctre.phoenix.sensors.WPI_Pigeon2;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

public interface ElevatorComponents {
    MotorController getLeftMasterMotor();

    MotorController getRightMasterMotor();

    PigeonIMU getPigeon();
}
