package frc.robot.commands.Telescope;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.telescope.Telescope;

import java.util.function.DoubleSupplier;

public class MoveToLength extends CommandBase {
    private final Telescope telescope;
    private DoubleSupplier setPoint;

    public MoveToLength(DoubleSupplier setPoint){
        this.setPoint = setPoint;
        telescope = Telescope.getInstance();
    }

    @Override
    public void initialize() {
        telescope.MoveToLength(setPoint.getAsDouble());
    }

    @Override
    public void execute() {
        telescope.updateMoveToLength(setPoint.getAsDouble());
    }

    @Override
    public boolean isFinished() {
        return telescope.isOnTarget();
    }

    @Override
    public void end(boolean interrupted) {
        telescope.stop();
    }
}
