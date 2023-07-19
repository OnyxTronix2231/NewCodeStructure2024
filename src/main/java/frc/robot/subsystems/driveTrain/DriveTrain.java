package frc.robot.subsystems.driveTrain;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
    private DriveTrainComponnents driveTrainComponnents;
    private static DriveTrain instance;

    public DriveTrain(DriveTrainComponnents driveTrainComponnents) {
        this.driveTrainComponnents = driveTrainComponnents;
    }

    public void arcadeDrive(double speed, double rotation) {
        driveTrainComponnents.getDifferentialDrive().arcadeDrive(speed, rotation);
    }

    public void stop() {
        driveTrainComponnents.getDifferentialDrive().arcadeDrive(0, 0);
    }

    public static DriveTrain initDriveTrain(DriveTrainComponnents driveTrainComponnents) {
        if (instance == null) {
            instance = new DriveTrain(driveTrainComponnents);
        }
        return instance;
    }

    public DriveTrainComponnents getDriveTrainComponnents() {
        return driveTrainComponnents;
    }

    public static DriveTrain getInstance() {
        return instance;
    }
}
