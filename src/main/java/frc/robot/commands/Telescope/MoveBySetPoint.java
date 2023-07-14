package frc.robot.commands.Telescope;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Telescope.Telescope;
import frc.robot.subsystems.Telescope.TelescopeComponentsImpl;
import pid.CtreMotionMagicController;

import java.util.function.DoubleSupplier;

public class MoveBySetPoint extends CommandBase {
    private Telescope telescope;
    private DoubleSupplier setPoint;

    @Override
    public void execute() {
        telescope.moveBySetPoint(setPoint.getAsDouble());
    }

    @Override
    public boolean isFinished() {
        return telescope.isOnSetPoint();
    }
}
