package frc.robot.robotControl;

import commandControl.CommandConsoleController;
import commandControl.CommandOnyxXboxController;
import frc.robot.subsystems.tank.TankConstants;

import static frc.robot.Configurations.DRIVE_JOYSTICK_PORT;

public class DriverOi {

    private final CommandConsoleController controller;

    public DriverOi() {
        controller = new CommandOnyxXboxController(DRIVE_JOYSTICK_PORT);
        double forward = -controller.getRawAxis(TankConstants.LEFT_JOYSTICK_AXIS_Y);
        double turn = controller.getRawAxis(TankConstants.RIGHT_JOYSTICK_AXIS_X);
    }








}
