package frc.robot.robotControl;

import commandControl.CommandConsoleController;
import commandControl.CommandOnyxXboxController;
import commandControl.CommandPlaystation5Controller;
import frc.robot.Commands.DriveCommand;
import frc.robot.subsystems.driveTrain.DriveTrain;

import static frc.robot.Configurations.DRIVE_JOYSTICK_PORT;

public class DriverOi {

    private final CommandPlaystation5Controller controller;

    public DriverOi() {
        controller = new CommandPlaystation5Controller(DRIVE_JOYSTICK_PORT);
        DriveTrain.getInstance().setDefaultCommand(new DriveCommand(controller::getLeftY, controller::getRightX));
    }
}
