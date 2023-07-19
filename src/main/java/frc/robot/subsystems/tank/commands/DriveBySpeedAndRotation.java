    package frc.robot.subsystems.tank.commands;

    import edu.wpi.first.wpilibj.drive.DifferentialDrive;
    import edu.wpi.first.wpilibj2.command.CommandBase;
    import frc.robot.robotControl.DriverOi;
    import frc.robot.subsystems.tank.TankConstants;
    import frc.robot.subsystems.tank.*;
    import edu.wpi.first.wpilibj2.command.SubsystemBase;

    public class DriveBySpeedAndRotation  extends CommandBase {
        private  DriverOi driverOi;
        private  DifferentialDrive driveTrain;

        public DriveBySpeedAndRotation(DriverOi driverOi, DifferentialDrive driveTrain) {
            this.driverOi = driverOi;
            this.driveTrain = driveTrain;
            addRequirements(driveTrain);
        }


            driveTrain.arcadeDrive(forward, rotation);


    }
