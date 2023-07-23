package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.tankDriveTrain.TankConstants;
import frc.robot.subsystems.tankDriveTrain.TankDriveTrain;

public class Rotate180DegreesCommand extends CommandBase {
    private TankDriveTrain driveTrain;

    private TankConstants constants;

    public Rotate180DegreesCommand(){
        driveTrain = TankDriveTrain.getInstance();
        addRequirements(driveTrain);
    }

    @Override
    public void initialize() {
        driveTrain.resetRotation();
    }

    @Override
    public void execute() {
        driveTrain.drive(0,180);
    }
    @Override
    public boolean isFinished() {
        return (driveTrain.getRotation()>=180);
    }

    @Override
    public void end(boolean interrupted) {
        driveTrain.stop();
    }

}
