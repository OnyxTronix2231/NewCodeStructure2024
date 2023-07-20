package frc.robot.subsystems.tankDriveTrain;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TankDriveTrain extends SubsystemBase {
       private TankComponents components;

       private static TankDriveTrain instance;

       public TankDriveTrain(TankComponents components){
           this.components = components;
       }

       public void drive(double speed, double rotation){
           components.getDifferentialDrive().arcadeDrive(speed, rotation);
       }

       public void stop(){
           drive(0,0);
       }

    public static TankDriveTrain initTankDriveTrain(TankComponents componnents) {
        if (instance == null) {
            instance = new TankDriveTrain(componnents);
        }
        return instance;
    }

    public static TankDriveTrain getInstance() {
        return instance;
    }



    }
