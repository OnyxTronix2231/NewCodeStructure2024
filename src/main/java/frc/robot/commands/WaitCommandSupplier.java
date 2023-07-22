package frc.robot.commands;

import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

import java.util.function.DoubleSupplier;

public class WaitCommandSupplier extends CommandBase {
    private edu.wpi.first.wpilibj.Timer timer = new Timer();
    private final DoubleSupplier duration;

    public WaitCommandSupplier(DoubleSupplier duration) {
        this.duration = duration;
    }

    @Override
    public void initialize() {
        timer.restart();
    }

    @Override
    public void end(boolean interrupted) {
        timer.stop();
    }

    @Override
    public boolean isFinished() {
        return timer.hasElapsed(duration.getAsDouble());
    }

    @Override
    public boolean runsWhenDisabled() {
        return true;
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        super.initSendable(builder);
        builder.addDoubleProperty("duration", duration, null);
    }
}
