package frc.robot.subsystems.telescope;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.DoubleSupplier;

public class Telescope extends SubsystemBase {
    private static Telescope instance;
    private TelescopeComponents components;

    public Telescope(TelescopeComponents components){
        this.components = components;
    }

    public static void initTelescope(TelescopeComponents components){
        instance = new Telescope(components);
    }

    public static Telescope getInstance(){
        return instance;
    }

    public void setSpeed(DoubleSupplier speed){
        components.getMotor().set(speed.getAsDouble());
    }

    public void stop(){
        components.getMotor().set(0);
    }
}
