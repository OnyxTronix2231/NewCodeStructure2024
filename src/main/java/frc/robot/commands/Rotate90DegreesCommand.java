package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.tankDriveTrain.TankDriveTrain;

public class Rotate90DegreesCommand extends CommandBase {
    private TankDriveTrain driveTrain;

    public Rotate90DegreesCommand(){
        driveTrain = TankDriveTrain.getInstance();
        addRequirements(driveTrain);


    }

    @Override
    public void execute() {
        driveTrain.drive(1,90);
    }

    @Override
    public void end(boolean interrupted) {
        driveTrain.stop();
    }
}
