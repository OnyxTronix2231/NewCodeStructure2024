package frc.robot.subsystems.driveTrain;

public class DriveTrain {

    private static DriveTrain instance;
    private DriveTrainComponents components;

    private DriveTrain(DriveTrainComponents components) {
        this.components = components;
    }

    public static DriveTrain getInstance() {
        return instance;
    }

    public static void initDriveTrain(DriveTrainComponents components) {
        instance = new DriveTrain(components);
    }

    public void arcadeDrive(double speed, double rotation) {
        components.getDifferentialDrive().arcadeDrive(speed, rotation);
    }

    public void stop() {
        this.arcadeDrive(0.0, 0.0);
    }
}
