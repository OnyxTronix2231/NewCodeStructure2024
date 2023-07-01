package frc.robot.logging;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.commands.driveTrain.MoveByDistance;
import frc.robot.subsystems.driveTrain.DriveTrain;
import frc.robot.subsystems.driveTrain.DriveTrainComponents;
import frc.robot.subsystems.driveTrain.DriveTrainComponentsImpl;
import frc.robot.subsystems.driveTrain.features.PoseEstimator;
import frc.robot.subsystems.driveTrain.features.SwerveModule;

public class DriveTrainShuffleboard {

    private DriveTrain driveTrain;
    private ShuffleboardTab tab;

    public DriveTrainShuffleboard(DriveTrainComponents components) {
        driveTrain = DriveTrain.getInstance();
        SwerveModule[] swerveModules = components.getSwerveModules();

        tab = Shuffleboard.getTab("DriveTrain");
        tab.addNumber("FL encoderUnits ", () -> swerveModules[0].getAbsEncDeg());
//        tab.addNumber("FR encoderUnits ", () -> swerveModules[1].getAbsEncDeg());
//        tab.addNumber("BL encoderUnits ", () -> swerveModules[2].getAbsEncDeg());
//        tab.addNumber("BR encoderUnits ", () -> swerveModules[3].getAbsEncDeg());
        //tab.addNumber("encoder units ", () -> swerveModules[0].getAngleOffset());

        tab.addNumber("FL CurrentModuleAngle", () -> swerveModules[0].getCurrentAbsoluteDeg());
//        tab.addNumber("FR CurrentModuleAngle", () -> swerveModules[1].getCurrentAbsoluteDeg());
//        tab.addNumber("BL CurrentModuleAngle", () -> swerveModules[2].getCurrentAbsoluteDeg());
//        tab.addNumber("BR CurrentModuleAngle", () -> swerveModules[3].getCurrentAbsoluteDeg());

        tab.addNumber("Robot's angle", () -> PoseEstimator.getInstance().getHeading().getDegrees());

        tab.add("Turning 90 ",new MoveByDistance(new Pose2d(0, 0, Rotation2d.fromDegrees(90))));

    }
}