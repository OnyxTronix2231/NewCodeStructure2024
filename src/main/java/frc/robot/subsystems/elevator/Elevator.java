package frc.robot.subsystems.elevator;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Elevator extends SubsystemBase {
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

    public void setSpeed(double speed){
        components.getLeftMasterMotor().set(speed);
        components.getRightMasterMotor().set(speed);
    }

    public void stop() {
        setSpeed(0);
    }

    public double getHeading() {
       return components.getPigeon().getFusedHeading();
    }
}
