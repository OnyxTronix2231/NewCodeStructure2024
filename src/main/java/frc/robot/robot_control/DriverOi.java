package frc.robot.robot_control;

import commandControl.CommandConsoleController;
import commandControl.CommandOnyxXboxController;
import frc.robot.commands.driveTrain.DriveCommand;
import frc.robot.subsystems.driveTrain.DriveTrain;

import static frc.robot.Configurations.DRIVE_JOYSTICK_PORT;

public class DriverOi {

    private final CommandConsoleController controller;

    public DriverOi() {
        controller = new CommandOnyxXboxController(DRIVE_JOYSTICK_PORT);

        DriveTrain.getInstance().setDefaultCommand(new DriveCommand(controller::getLeftY, controller::getRightX));
    }
}
