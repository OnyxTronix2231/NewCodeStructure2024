package frc.robot.DriveTrain;

public class DriveTrain {

    private final DriveTrainComponents components;

    private static DriveTrain instance;

    public static void initDriveTrain(DriveTrainComponents components){
        instance = new DriveTrain(components);
    }

    public DriveTrain(DriveTrainComponents components) {
        this.components = components;
    }
     public void arcadeDrive(double speed, double arc){
        components.getDrive().arcadeDrive(speed, arc);
     }
     public void stopDrive(){
        arcadeDrive(0,0);
     }

}
