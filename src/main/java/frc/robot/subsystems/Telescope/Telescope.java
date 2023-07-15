package frc.robot.subsystems.Telescope;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import java.util.function.DoubleSupplier;

public class Telescope extends SubsystemBase {
    private TelescopeComponents components;

    private static Telescope instance;

    private Telescope(TelescopeComponents components) {
        this.components = components;
    }

    public static void initTelescope(TelescopeComponents components) {
        instance = new Telescope(components);
    }

    public static Telescope getInstance() {
        return instance;
    }

    public void setSpeed(double speed) {
        components.getMotor().set(speed);
    }

    public void moveBySetPoint(double setPoint) {
        components.getPositionController().setSetpoint(setPoint);
    }

    public void updateSetPoint(double setPoint){
        components.getPositionController().update(setPoint);
    }

    public void StopSetPoint(){
            setSpeed(0);
    }
    public boolean isOnSetPoint() {
        return components.getPositionController().isOnTarget(20);
    }
}
