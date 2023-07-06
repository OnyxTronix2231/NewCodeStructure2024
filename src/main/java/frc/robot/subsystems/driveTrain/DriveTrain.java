package frc.robot.subsystems.driveTrain;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {

    private DriveTrainComponents components;
    private static DriveTrain instance;

    private DriveTrain(DriveTrainComponents components) {
        this.components = components;
    }

    public static DriveTrain getInstance() {
        return instance;
    }

    public static void initDriveTrain(DriveTrainComponents components) {
        instance = new DriveTrain(components);
    }

    public void arcadeDrive(double speed, double rot) {
        components.getDifferentialDrive().arcadeDrive(speed, rot);
    }

    public void stop() {
        arcadeDrive(0, 0);
    }

}
