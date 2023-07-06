package frc.robot.subsystems.driveTrain;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {

    private static DriveTrain instance;
    private DriveTrainComponents components;

    private DriveTrain(DriveTrainComponents components) {
        this.components = components;
    }

    public static DriveTrain getInstance() {
        return instance;
    }

    public static void driveTrainInit(DriveTrainComponents components) {
        instance = new DriveTrain(components);
    }

    public void arcadeDrive(double speed ,double rotation){
        components.getDifferentialDrive().arcadeDrive(speed, rotation);
    }

    public void stop(){
        arcadeDrive(0,0);
    }
}
