package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.tankDriveTrain.TankDriveTrain;

import java.util.function.DoubleSupplier;

public class DriveCommand extends CommandBase {
    private TankDriveTrain driveTrain;
    private DoubleSupplier speedSupplier;
    private DoubleSupplier zRotationSupplier;

    public DriveCommand(DoubleSupplier speedSupplier, DoubleSupplier rotSupplier) {
        driveTrain = TankDriveTrain.getInstance();

        this.speedSupplier = speedSupplier;
        this.zRotationSupplier = rotSupplier;

        addRequirements(driveTrain);
    }

    @Override
    public void execute() {
       driveTrain.drive(
                speedSupplier.getAsDouble(),
                zRotationSupplier.getAsDouble()
        );
    }

    @Override
    public void end(boolean interrupted) {
        driveTrain.stop();
    }
}
