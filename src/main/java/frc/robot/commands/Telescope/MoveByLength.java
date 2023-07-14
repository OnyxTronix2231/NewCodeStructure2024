package frc.robot.commands.Telescope;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.telescope.Telescope;

import java.util.function.DoubleSupplier;

public class MoveByLength extends CommandBase {
    private final Telescope telescope;
    private DoubleSupplier length;

    public MoveByLength(DoubleSupplier length){
        this.length = length;
        telescope = Telescope.getInstance();
    }

    @Override
    public void initialize() {
        telescope.MoveByLength(length.getAsDouble());
    }

    @Override
    public void execute() {
        telescope.updateMoveByLength(length.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        telescope.stop();
    }
}
