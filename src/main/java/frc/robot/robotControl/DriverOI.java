package frc.robot.robotControl;

import commandControl.CommandPlaystation5Controller;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.Rotate90DegreesCommand;
import frc.robot.subsystems.tankDriveTrain.TankDriveTrain;
import static frc.robot.Configurations.DRIVE_JOYSTICK_PORT;

public class DriverOI {
    private final CommandPlaystation5Controller controller;

    public DriverOI() {
        controller = new CommandPlaystation5Controller(DRIVE_JOYSTICK_PORT);
        TankDriveTrain.getInstance().setDefaultCommand(new DriveCommand(controller::getLeftY, controller::getRightX));


        controller.buttonUp().whileTrue(new Rotate90DegreesCommand());

    }

}
