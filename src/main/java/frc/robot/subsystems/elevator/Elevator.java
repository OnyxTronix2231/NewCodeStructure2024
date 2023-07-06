package frc.robot.subsystems.elevator;

public class Elevator {

    private static Elevator instance;
    private ElevatorComponents components;

    private Elevator(ElevatorComponents components) {
        this.components = components;
    }

    public static Elevator getInstance() {
        return instance;
    }

    public static void initElevator(ElevatorComponents components) {
        instance = new Elevator(components);
    }

    public void set(double speed) {
        components.getLeftMasterMotor().set(speed);
        components.getRightMasterMotor().set(speed);
    }

    public void stop() {
        this.set(0);
    }

    public double getFusedHeading() {
        return components.getGyro().getPitch();
    }

    public void shake(double degree) {
        if (degree > 45)
            this.set(-1);
        if (degree < 30)
            this.set(1);
    }
}
