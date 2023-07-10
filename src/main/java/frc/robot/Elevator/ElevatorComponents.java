package frc.robot.Elevator;

import com.ctre.phoenix.sensors.PigeonIMU;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

public interface ElevatorComponents {
    public MotorController getLeftMasterMotor();

    public MotorController getRightMasterMotor();

    public MotorController getLeftSlaverMotor();

    public MotorController getRightSlaveMotor();

    public PigeonIMU getGyro();

}
