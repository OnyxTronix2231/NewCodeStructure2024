package frc.robot.subsystems.telescope;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Telescope extends SubsystemBase {
    private final TelescopeComponnentsImpl componnents;
    private static Telescope instance;

    public Telescope(TelescopeComponnentsImpl componnents) {
        this.componnents = componnents;
    }
    public void setSpeed(double speed) {
        componnents.getMasterMotor().set(speed);
    }
    public void stop() {
        componnents.getMasterMotor().set(0);
    }
    public static Telescope initInstance() {
        if (instance==null) {
            instance = new Telescope(new TelescopeComponnentsImpl());
        }
        return instance;
    }
    public static Telescope getInstance() {
        return instance;
    }
}
