package frc.robot.logging;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.subsystems.driveTrain.DriveTrain;

public class DriveTrainShuffleboard {

    private DriveTrain driveTrain;
    private ShuffleboardTab tab;

    public DriveTrainShuffleboard() {
        driveTrain = DriveTrain.getInstance();

        tab = Shuffleboard.getTab("DriveTrain");

        //tab.addNumber("motorCurrent", driveTrain::getCurrent);
    }
}
