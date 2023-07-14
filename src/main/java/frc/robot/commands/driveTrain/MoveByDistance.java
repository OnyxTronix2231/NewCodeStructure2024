package frc.robot.commands.driveTrain;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.driveTrain.DriveTrain;
import frc.robot.subsystems.driveTrain.features.AutoPilotController;
import frc.robot.subsystems.driveTrain.features.KeepAngleController;
import frc.robot.subsystems.driveTrain.features.PoseEstimator;

/**
 * this function purpose is to automatically move to a desiredPose in the field. For Example:
 * in the 2023 frc game ChargedUp, we wanted to move to a set pose to score in a Scoring Position automatically.
 * using PoseEstimator and Vision Values.
 */
public class MoveByDistance extends CommandBase {
    private AutoPilotController autoPilotController;
    private DriveTrain driveTrain;

    public MoveByDistance(Pose2d deltaPose) {
        autoPilotController = new AutoPilotController(deltaPose);
        driveTrain = DriveTrain.getInstance();
        addRequirements(driveTrain);
    }

    @Override
    public void initialize() {
        driveTrain.initSwerveDrive(autoPilotController.initController());
    }

    @Override
    public void execute() {
        driveTrain.updateSwerveDrive(autoPilotController.updateController());
    }

    @Override
    public boolean isFinished() {
        return autoPilotController.isFinished();
    }

    @Override
    public void end(boolean interrupted) {
        KeepAngleController.getInstance().setKeepedAngle(PoseEstimator.getInstance().getHeading());
        driveTrain.stopDrive();
    }
}
