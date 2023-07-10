package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.driveTrain.DriveTrain;

import java.util.function.DoubleSupplier;

public class DriveCommand extends CommandBase {
    private DriveTrain driveTrain;
    private DoubleSupplier speedSupplier;
    private DoubleSupplier rotSupplier;

    public DriveCommand(DoubleSupplier speedSupplier, DoubleSupplier rotSupplier) {
        driveTrain = DriveTrain.getInstance();
        this.speedSupplier = speedSupplier;
        this.rotSupplier = rotSupplier;
        addRequirements(driveTrain);
    }

    @Override
    public void execute() {
        driveTrain.arcadeDrive(speedSupplier.getAsDouble(),rotSupplier.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        driveTrain.stop();
    }
}
