package frc.robot.commands.driveTrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.driveTrain.DriveTrain;

import java.util.function.DoubleSupplier;

public class DriveCommand extends CommandBase {

    private final DriveTrain drivetrain;
    private final DoubleSupplier speed;
    private final DoubleSupplier rotation;

    public DriveCommand(DoubleSupplier speed, DoubleSupplier rotation) {
        this.speed = speed;
        this.rotation = rotation;

        drivetrain = DriveTrain.getInstance();
    }

    @Override
    public void execute() {
        drivetrain.arcadeDrive(speed.getAsDouble(), rotation.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.stop();
    }
}
