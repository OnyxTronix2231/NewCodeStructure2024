package frc.robot.subsystems.elevator;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
    private static Elevator instance;
    private ElevatorComponents components;

    private Elevator(ElevatorComponents components) {
        this.components = components;
    }

    public static void init(ElevatorComponents components) {
        instance = new Elevator(components);
    }

    public static Elevator getInstance() {
        return instance;
    }

    public void setSpeed(double speed) {
        components.getRightMasterMotor().set(speed);
        components.getLeftMasterMotor().set(speed);
    }

    public void stop() {
        setSpeed(0);
    }

    public double getAngle() {
        return components.getGyro().getFusedHeading();
    }

    public void forSafty() {
        if (getAngle() > 100)
            setSpeed(0);
    }

}
