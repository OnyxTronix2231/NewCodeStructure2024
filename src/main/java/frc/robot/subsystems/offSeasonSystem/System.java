package frc.robot.subsystems.offSeasonSystem;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.concept.Concept;
import frc.robot.subsystems.concept.ConceptComponentsImpl;

public class System extends CommandBase {

    private SystemComponents components;

    private static System instance;

    public System(SystemComponents components) {
        this.components = components;
    }

    public void moveBySpeed(double speed) {
        components.getMasterMotor().set(speed);
    }

    public void stop() {
        moveBySpeed(0);
    }

    public static System initInstance(SystemComponentsComponentsImpl components) {
        if (instance == null) {
            instance = new System(components);
        }
        return instance;
    }

    public static System getInstance() {
        return instance;
    }
}
