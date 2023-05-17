package frc.robot.tests;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.driveTrain.DriveCommand;

public class TestDriveTrain extends SequentialCommandGroup {

    public TestDriveTrain() {
        super(new DriveCommand(() -> 0.6, () -> 0).withTimeout(1)
        );
    }
}
