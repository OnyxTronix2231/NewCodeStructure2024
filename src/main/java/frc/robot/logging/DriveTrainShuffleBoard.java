package frc.robot.logging;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.subsystems.driveTrain.DriveTrain;
import frc.robot.subsystems.driveTrain.DriveTrainComponents;
import frc.robot.subsystems.driveTrain.features.PoseEstimator;
import frc.robot.subsystems.driveTrain.features.SwerveModule;

public class DriveTrainShuffleBoard {

    public DriveTrainShuffleBoard(DriveTrain driveTrain, DriveTrainComponents components) {

        ShuffleboardTab SwerveTab = Shuffleboard.getTab("Swerve");

        SwerveModule[] swerveModules = components.getSwerveModules();

        SwerveTab.addString("Pose",()-> PoseEstimator.getInstance().getPose2d().toString());
        SwerveTab.addNumber("CurrentModuleAngle", () -> swerveModules[0].getCurrentAbsoluteDeg());
    }
}
