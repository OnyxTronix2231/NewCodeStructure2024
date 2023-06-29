package frc.robot.commands.driveTrain;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.driveTrain.features.PoseEstimator;

public class ResetPose extends InstantCommand {
    public ResetPose() {
        super(()-> PoseEstimator.getInstance().setPose2d(new Pose2d()));
        addRequirements(PoseEstimator.getInstance());
    }
}
