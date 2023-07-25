package frc.robot.subsystems.tankDriveTrain;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class DriveTrainShuffleboard {
    public DriveTrainShuffleboard(TankComponents components){
        TankDriveTrain driveTrain = TankDriveTrain.getInstance();
        ShuffleboardTab tab = Shuffleboard.getTab("drive train");
        tab.addNumber("current rotation", () -> components.getPigeon().getYaw());


    }


}
