package frc.robot.logging;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.subsystems.driveTrain.DriveTrain;
import frc.robot.subsystems.driveTrain.DriveTrainComponents;
import frc.robot.subsystems.driveTrain.DriveTrainComponentsImpl;

public class DriveTrainShuffleboard {

    private DriveTrain driveTrain;
    private ShuffleboardTab tab;

    public DriveTrainShuffleboard(DriveTrainComponents components) {
        driveTrain = DriveTrain.getInstance();

        tab = Shuffleboard.getTab("DriveTrain");
        tab.addNumber("encoder units ", () -> driveTrain.getSwerveModulesPosition()[0].angle.getRadians());

        tab.addNumber("robot's angle ", () -> )
        //זווית של הרובוט, זווית של כל מודלוה, משהו מהאינקודר, סיבוב של 90 מעלות.
        //של לדים: להציג צבע נוכחי, לנחליף לאדום, להחליף לרייבואואוואואואואואואו
        //tab.addDouble("EncoderCounter", components.getLeftMasterMotor().);
    }
}
