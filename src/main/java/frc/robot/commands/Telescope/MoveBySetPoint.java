package frc.robot.commands.Telescope;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Telescope.Telescope;


import java.util.function.DoubleSupplier;

public class MoveBySetPoint extends CommandBase {
    private final Telescope telescope;
    private final DoubleSupplier setPoint;
    public  MoveBySetPoint(DoubleSupplier setPoint) {
        this.setPoint = setPoint;
        telescope = Telescope.getInstance();
    }

    @Override
    public void initialize() {
        telescope.moveBySetPoint(setPoint.getAsDouble());
    }

    @Override
    public void execute() {
        telescope.moveBySetPoint(setPoint.getAsDouble());
    }

    @Override
    public boolean isFinished() {
        return telescope.isOnSetPoint();
    }

    @Override
    public void end(boolean interrupted) {
        telescope.setSpeed(0);
    }
}

