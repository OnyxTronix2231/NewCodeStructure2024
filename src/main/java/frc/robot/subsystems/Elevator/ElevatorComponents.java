package frc.robot.subsystems.Elevator;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.PigeonIMU;

public interface ElevatorComponents {
    public WPI_TalonFX getElevatorLeftMaster();

    public WPI_TalonFX getElevatorRightMaster();

    public PigeonIMU getGyro();

}
