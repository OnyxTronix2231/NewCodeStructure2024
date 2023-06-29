package frc.robot.logging;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.subsystems.driveTrain.DriveTrain;
import frc.robot.subsystems.driveTrain.DriveTrainComponents;
import frc.robot.subsystems.driveTrain.features.PoseEstimator;
import frc.robot.subsystems.driveTrain.features.SwerveModule;

public class DriveTrainShuffleBoard {

    public DriveTrainShuffleBoard(DriveTrain driveTrain, DriveTrainComponents components) {

        ShuffleboardTab tab = Shuffleboard.getTab("Swerve");
        SwerveModule[] swerveModules = components.getSwerveModules();
        tab.addString("Pose",()-> PoseEstimator.getInstance().getPose2d().toString());
        tab.addNumber("CurrentModuleAngle", () -> swerveModules[0].getCurrentAbsoluteDeg());
        tab.addNumber("cancoderAng", () -> swerveModules[0].getAbsEncDeg() - swerveModules[0].getAngleOffset());}

}
