package frc.robot.subsystems.telescope;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.DoubleSupplier;

import static frc.robot.data.TelescopeConstants.*;
import static frc.robot.data.TelescopeConstants.Calculations.encToLen;

public class Telescope extends SubsystemBase {
    private final TelescopeComponents components;

    public Telescope(TelescopeComponents components){
        this.components = components;
    }

    public void MoveBySpeed(DoubleSupplier speed){
        components.getMotor().set(speed.getAsDouble());
    }

    public double getCurrentPosition(){
        return encToLen((int) components.getEncoder().getCount());
    }

    public boolean isOnTarget(){
        return components.getController().isOnTarget(TOLERANCE);
    }

    public void MoveToLength(double setPoint){
        components.getController().setSetpoint(setPoint);
        components.getController().enable();
    }

    public void updateMoveToLength(double setPoint){
        components.getController().update(setPoint);
    }

    public void MoveByLength(double length){
        components.getController().setSetpoint(getCurrentPosition() + length);
        components.getController().enable();
    }

    public void updateMoveByLength(double length){
        components.getController().setSetpoint(getCurrentPosition() + length);
    }

    public void stop(){
        components.getMotor().set(0);
        components.getController().disable();
    }

    private static Telescope instance;

    public static void initTelescope(TelescopeComponents components){
        instance = new Telescope(components);
    }

    public static Telescope getInstance(){
        return instance;
    }

}
