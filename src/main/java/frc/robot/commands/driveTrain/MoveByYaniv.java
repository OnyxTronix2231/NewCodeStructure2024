package frc.robot.commands.driveTrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.concept.Concept;

import java.util.function.DoubleSupplier;

public class MoveByYaniv extends CommandBase {
    private Concept concept;
    private DoubleSupplier speed;

    public MoveByYaniv(DoubleSupplier speed) {
        this.concept = Concept.getInstance();
        this.speed = speed;
        addRequirements(concept);
    }

    @Override
    public void initialize() {
        concept.moveBySpeed(speed.getAsDouble());
    }

    @Override
    public void execute() {
        concept.moveBySpeed(speed.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        concept.stop();
    }

}
