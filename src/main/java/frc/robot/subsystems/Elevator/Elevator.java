package frc.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.data.ElevatorConstant.*;

public class Elevator extends SubsystemBase {
    private ElevatorComponents components;

    private static Elevator instance;

    private Elevator(ElevatorComponents components) {
        this.components = components;
    }

    public static void initElevator(ElevatorComponents components) {
        instance = new Elevator(components);
    }

    public static Elevator getInstance() {
        return instance;
    }

    public void setSpeed(double speed){
        components.getLeftMasterMotor().set(speed);
        components.getRightMasterMotor().set(speed);
    }

    public void stop(){
        setSpeed(0);
    }

    public double getHeading(){
        return components.getGyro().getFusedHeading();
    }


    public void setSpeedByHeading() {
       if (getHeading() < 180)
           setSpeed(MAX_SPEED);
       else
           stop();
    }

}
