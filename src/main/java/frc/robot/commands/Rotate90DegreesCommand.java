package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;
import frc.robot.subsystems.tankDriveTrain.TankConstants;
import frc.robot.subsystems.tankDriveTrain.TankDriveTrain;

import static frc.robot.subsystems.tankDriveTrain.TankConstants.*;


public class Rotate90DegreesCommand extends CommandBase {
    private TankDriveTrain driveTrain;

    private TankConstants constants;
    private Timer timer;

    public Rotate90DegreesCommand(){
        driveTrain = TankDriveTrain.getInstance();
        addRequirements(driveTrain);
        timer = new Timer();

    }

    @Override
    public void initialize() {
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        driveTrain.drive(0,90);
    }

    @Override
    public boolean isFinished() {
        return timer.get() >= Tank90Time;
    }

    @Override
    public void end(boolean interrupted) {
        driveTrain.stop();
    }

}