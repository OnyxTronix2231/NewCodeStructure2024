package frc.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
    public final ElevatorComponents components;
    private static Elevator instance;

    public Elevator(ElevatorComponents components) {
        this.components = components;
    }

    public void setMotorsSpeed(double speed) {
        components.getElevatorRightMaster().set(speed);
        components.getElevatorLeftMaster().set(speed);
    }

    public void stop() {
        setMotorsSpeed(0);
    }

    public double getElevatorAngle() {
        return components.getGyro().getFusedHeading();
    }

    public void changeElevatorSpeedAccordingToAngle() {
        if (getElevatorAngle() < 50) {
            setMotorsSpeed(0.8);
        }
        if (getElevatorAngle() < 100 && getElevatorAngle() > 50) {
            setMotorsSpeed(0.5);
        }
        if (getElevatorAngle() > 100) {
            setMotorsSpeed(0.2);
        }
    }
    public static Elevator initInstance(ElevatorComponents elevatorComponents) {
        if (instance==null) {
            instance = new Elevator(elevatorComponents);
        }
        return instance;
    }
    public static Elevator getInstance() {
        return instance;
    }
}
