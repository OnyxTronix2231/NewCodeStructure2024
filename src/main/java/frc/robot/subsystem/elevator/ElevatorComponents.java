package frc.robot.subsystem.elevator;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.PigeonIMU;

public interface ElevatorComponents {

    WPI_TalonFX getRightMaster();

    WPI_TalonFX getLeftMaster();

    PigeonIMU getGyro();
}
