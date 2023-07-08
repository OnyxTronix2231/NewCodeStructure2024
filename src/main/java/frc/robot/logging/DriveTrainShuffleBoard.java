package frc.robot.logging;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import frc.robot.commands.driveTrain.MoveByDistance;
import frc.robot.subsystems.driveTrain.DriveTrain;
import frc.robot.subsystems.driveTrain.DriveTrainComponents;
import frc.robot.subsystems.driveTrain.features.PoseEstimator;
import frc.robot.subsystems.driveTrain.features.SwerveModule;
import frc.robot.led.LED;

public class DriveTrainShuffleBoard {

    private DriveTrain driveTrain;
    private ShuffleboardTab tab;

    public DriveTrainShuffleBoard(DriveTrainComponents components) {
        driveTrain = DriveTrain.getInstance();
        SwerveModule[] swerveModules = components.getSwerveModules();

        tab = Shuffleboard.getTab("DriveTrain");
        tab.addNumber("FL encoderUnits ", () -> swerveModules[0].getAbsEncDeg());
//        tab.addNumber("FR encoderUnits ", () -> swerveModules[1].getAbsEncDeg());
//        tab.addNumber("BL encoderUnits ", () -> swerveModules[2].getAbsEncDeg());
//        tab.addNumber("BR encoderUnits ", () -> swerveModules[3].getAbsEncDeg());

        tab.addNumber("FL CurrentModuleAngle", () -> swerveModules[0].getCurrentAbsoluteDeg());
//        tab.addNumber("FR CurrentModuleAngle", () -> swerveModules[1].getCurrentAbsoluteDeg());
//        tab.addNumber("BL CurrentModuleAngle", () -> swerveModules[2].getCurrentAbsoluteDeg());
//        tab.addNumber("BR CurrentModuleAngle", () -> swerveModules[3].getCurrentAbsoluteDeg());

        tab.addNumber("Robot's angle", () -> PoseEstimator.getInstance().getHeading().getDegrees());

        //tab.add("Turning 90 ",new MoveByDistance(new Pose2d(0, 0, Rotation2d.fromDegrees(90))));
//        rotate 90d, (not working)


           tab.add("change color Red", new InstantCommand(()-> LED.getInstance().setStrip(new Color(255, 0, 0))));
//change color to red
           tab.add("change color Rainbow", new InstantCommand(()-> LED.getInstance().setGaming(3)));
           //change to rainbow (not working)

        tab.addString("get current color", ()-> LED.getInstance().getCurrentColor());
        // Get current color

        tab.add("change color null", new InstantCommand(()-> LED.getInstance().setStrip(new Color(0, 0, 0))));
    }
}