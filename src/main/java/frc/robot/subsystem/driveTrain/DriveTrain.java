package frc.robot.subsystem.driveTrain;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.subsystem.driveTrain.Constants.DiffrentialDriveConst.X_SPEED;
import static frc.robot.subsystem.driveTrain.Constants.DiffrentialDriveConst.Z_ROTATIONS;

public class DriveTrain extends SubsystemBase {

    private DriveTrainComponentsImpl components;

    private DriveTrain() {
    }
    public void setRightMotorSpeed(double speed) {
        components.getRightMotor().set(speed);
    }

    public void setLeftMotorSpeed(double speed) {
        components.getLeftMotor().set(speed);
    }

    public void stopRight() {
        components.getRightMotor().set(0);
    }

    public void stopLeft() {
        components.getLeftMotor().set(0);
    }

    public void stop() {
        stopRight();
        stopLeft();
    }

    public void arcadeDrive() {
        components.getDifferentialDrive().arcadeDrive(X_SPEED, Z_ROTATIONS, false);
    }

    private static DriveTrain instance = null;

    public static DriveTrain getInstance() {
        if (instance == null) {
            instance = new DriveTrain();
        }
        return instance;
    }

    public void init(DriveTrainComponentsImpl components) {
        this.components = components;
    }
}
