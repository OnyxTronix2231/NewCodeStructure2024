package frc.robot.robotControl;

import commandControl.CommandConsoleController;
import commandControl.CommandJoystickAxis;
import commandControl.CommandOnyxXboxController;
import commandControl.CommandPlaystation5Controller;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.driveTrain.MoveByDistance;
import frc.robot.commands.driveTrain.ResetPose;
import frc.robot.commands.driveTrain.SwerveDrive;
import frc.robot.subsystems.driveTrain.DriveTrain;



import static frc.robot.Configurations.DRIVE_JOYSTICK_PORT;

public class DriverOi {

    private final CommandConsoleController controller;
    private DriveTrain driveTrain = DriveTrain.getInstance();
    public DriverOi() {
        controller = new CommandPlaystation5Controller(DRIVE_JOYSTICK_PORT);

        Trigger resetPose = controller.centerLeft();
        Trigger moveByDistance = controller.rightTrigger();

        CommandJoystickAxis xAxis = controller.leftYAxis();
        CommandJoystickAxis yAxis = controller.leftXAxis();
        CommandJoystickAxis rotAxis = controller.rightXAxis();

        driveTrain.getInstance().setDefaultCommand(new SwerveDrive(
                () -> (-xAxis.getRawAxis()),
                () -> (-yAxis.getRawAxis()),
                () -> (-rotAxis.getRawAxis()),
                () -> true
        ));
        resetPose.onTrue(new ResetPose());
        moveByDistance.whileTrue(new MoveByDistance(new Pose2d(0, 0, Rotation2d.fromDegrees(90))));
    }
}
