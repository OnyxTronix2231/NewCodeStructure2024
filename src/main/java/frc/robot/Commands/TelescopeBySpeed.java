package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.telescope.Telescope;
import java.util.function.DoubleSupplier;

public class TelescopeBySpeed extends CommandBase {
    private Telescope telescope;
    private DoubleSupplier speedSupplier;

    public TelescopeBySpeed(DoubleSupplier speedSupplier) {
        this.telescope = Telescope.getInstance();
        this.speedSupplier = speedSupplier;
        addRequirements(telescope);
    }

    @Override
    public void initialize() {
        telescope.setSpeed(speedSupplier.getAsDouble());
    }

    @Override
    public void execute() {
        telescope.setSpeed(speedSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        telescope.stop();
    }
}
