package frc.robot.logging;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.subsystems.driveTrain.DriveTrain;
import frc.robot.subsystems.driveTrain.DriveTrainComponents;
import frc.robot.subsystems.driveTrain.features.PoseEstimator;
import frc.robot.subsystems.driveTrain.features.SwerveModule;

public class DriveTrainShuffleBoard {

    public DriveTrainShuffleBoard(DriveTrain driveTrain, DriveTrainComponents components) {

        ShuffleboardTab swerveTab = Shuffleboard.getTab("Swerve");

        SwerveModule[] swerveModules = components.getSwerveModules();

        swerveTab.addNumber("CurrentModuleAngle", () -> swerveModules[0].getCurrentAbsoluteDeg());
        swerveTab.addString("Pose", ()->PoseEstimator.getInstance().getFormattedPose()).withPosition(0, 0).withSize(2, 0);
        swerveTab.add("Field",PoseEstimator.getInstance().getFieldPose()).withPosition(2, 0).withSize(6, 4);

    }
}
