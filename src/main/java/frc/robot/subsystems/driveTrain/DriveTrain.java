package frc.robot.subsystems.driveTrain;

import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {

    private DriveTrainComponents components;

    private static DriveTrain instance;

    private DriveTrain(DriveTrainComponents components) {
        this.components = components;
    }

    public void arcadeDrive(double speed, double rotation) {
        components.getDifferentialDrive().arcadeDrive(speed, rotation);
    }

    public void stop(){
        arcadeDrive(0.0,0.0);
    }

    public static void initDriveTrain(DriveTrainComponents components){
        instance = new DriveTrain(components);
    }

    public static DriveTrain getInstance() {
        return instance;
    }


}

