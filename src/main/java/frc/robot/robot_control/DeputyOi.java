package frc.robot.robot_control;

import commandControl.CommandConsoleController;
import commandControl.CommandOnyxXboxController;

import static frc.robot.Configurations.DEPUTY_JOYSTICK_PORT;

public class DeputyOi {
    private final CommandConsoleController controller;

    public DeputyOi() {
        controller = new CommandOnyxXboxController(DEPUTY_JOYSTICK_PORT);
    }

}
