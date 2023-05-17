package frc.robot.robotControl;

import commandControl.CommandConsoleController;
import commandControl.CommandOnyxXboxController;

import static frc.robot.Configurations.DRIVE_JOYSTICK_PORT;

public class DriverOi {

    private final CommandConsoleController controller;

    public DriverOi() {
        controller = new CommandOnyxXboxController(DRIVE_JOYSTICK_PORT);
    }
}
