package frc.robot.logging;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.subsystems.driveTrain.DriveTrain;
import frc.robot.subsystems.driveTrain.DriveTrainComponents;

public class DriveTrainShuffleboard {

    private DriveTrain driveTrain;
    private ShuffleboardTab tab;

    public DriveTrainShuffleboard(DriveTrainComponents components) {
        driveTrain = DriveTrain.getInstance();

        tab = Shuffleboard.getTab("DriveTrain");

        tab.addNumber("motorCurrent", driveTrain::getCurrent);

        //tab.addDouble("EncoderCounter", components.getLeftMasterMotor().);
    }
}
