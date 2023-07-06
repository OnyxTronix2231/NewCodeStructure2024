package frc.robot.subsystems.driveTrain;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.subsystems.driveTrain.DriveTrainConstants.*;

public class DriveTrain extends SubsystemBase {

    private static DriveTrain instance;
    private DriveTrainComponents driveTrainComponents;

    private DriveTrain(DriveTrainComponents driveTrainComponents) {
        this.driveTrainComponents = driveTrainComponents;
    }

    public static DriveTrain getInstance() {
        return instance;
    }

    public void initDriveTrain(DriveTrainComponents driveTrainComponents) {
        instance = new DriveTrain(driveTrainComponents);
    }

    public void arcadeDrive(double speed, double rotation) {
        driveTrainComponents.getDifferentialDrive()
                .arcadeDrive(speed, rotation);
    }

    public void stop() {
        arcadeDrive(0, 0);
    }

}
