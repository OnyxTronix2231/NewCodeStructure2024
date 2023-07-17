package frc.robot.subsystems.concept;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Concept extends SubsystemBase {
    private final ConceptComponents components;
    private static Concept instance;


    public Concept(ConceptComponents components) {
        this.components = components;
    }

    public void moveBySpeed(double speed) {
        components.getYaniv().set(speed);
    }

    public void stop() {
        moveBySpeed(0);
    }

    public static Concept initInstance(ConceptComponentsImpl components) {
        if (instance == null) {
            instance = new Concept(components);
        }
        return instance;
    }

    public static Concept getInstance() {
        return instance;
    }
}
