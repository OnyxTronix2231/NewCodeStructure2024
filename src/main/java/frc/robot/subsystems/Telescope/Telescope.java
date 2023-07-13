package frc.robot.subsystems.Telescope;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

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








}
