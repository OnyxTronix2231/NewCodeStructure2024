package frc.robot.commands.Telescope;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.telescope.Telescope;

import java.util.function.DoubleSupplier;

public class MoveBySpeed extends CommandBase {
    private DoubleSupplier speed;
    private Telescope telescope;

    public MoveBySpeed(DoubleSupplier speed){
        telescope = Telescope.getInstance();
        this.speed = speed;
    }

    @Override
    public void initialize() {
        telescope.MoveBySpeed(speed);
    }

    @Override
    public void execute() {
        telescope.MoveBySpeed(speed);
    }

    @Override
    public void end(boolean interrupted) {
        telescope.stop();
    }
}
