package frc.robot.commands.driveTrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.subsystems.concept.Concept;
import frc.robot.subsystems.offSeasonSystem.System;

import java.util.function.DoubleSupplier;

public class SystemBySpeed extends CommandBase {
    private System system;
    private DoubleSupplier speed;

    public SystemBySpeed(DoubleSupplier speed) {
        this.system = System.getInstance();
        this.speed = speed;
    }

    @Override
    public void initialize() {
        system.moveBySpeed(speed.getAsDouble());
    }

    @Override
    public void execute() {
        system.moveBySpeed(speed.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        system.stop();
    }

}
