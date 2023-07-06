package frc.robot.commands.driveTrain;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.driveTrain.features.PoseEstimator;
/***
 * This Command purpose is to reset Wheels direction before EveryMatch and set odometry before 15 seconds of auto
 */
public class ResetPose extends InstantCommand {

    public ResetPose(Pose2d deltaPose) {
        super(()-> PoseEstimator.getInstance().setPose2d(deltaPose));
    }
}
