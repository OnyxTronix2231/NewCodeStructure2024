package frc.robot.subsystem.elevator;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {

    private ElevatorComponentsImpl components;

    private Elevator() {
    }

    public void setRightMotorSpeed(double speed) {
        components.getRightMaster().set(speed);
    }

    public void setLeftMotorSpeed(double speed) {
        components.getLeftMaster().set(speed);
    }

    public double getFusedHeading() {
        return components.getGyro().getFusedHeading();
    }

    public static Elevator instance = null;

    public static Elevator getInstance() {
        if (instance == null) {
            instance = new Elevator();
        }
        return instance;
    }
}
