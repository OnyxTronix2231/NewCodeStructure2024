package frc.robot.subsystems.driveTrain;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.driveTrain.features.KeepAngleController;
import frc.robot.subsystems.driveTrain.features.PoseEstimator;
import frc.robot.subsystems.driveTrain.features.SwerveModule;

import static frc.robot.subsystems.driveTrain.DriveTrainConstants.*;

public class DriveTrain extends SubsystemBase {

    private final DriveTrainComponents components;

    public DriveTrain(DriveTrainComponents components) {
        this.components = components;
        resetWheelDirections();
    }

    public void resetWheelDirections() {
        for (SwerveModule module : components.getSwerveModules()) {
            module.resetToAbsolute();
        }
    }

    public SwerveModulePosition[] getSwerveModulesPosition() {
        int length = components.getSwerveModules().length;
        SwerveModulePosition[] swerveModulePositions = new SwerveModulePosition[length];
        for (int i = 0; i < length; i++) {
            swerveModulePositions[i] = components.getSwerveModules()[i].getPosition();
        }
        return swerveModulePositions;
    }

    public ChassisSpeeds getSpeedsRTR(double xSpeed, double ySpeed, double rotSpeed) {
        return new ChassisSpeeds(
                xSpeed,
                ySpeed,
                rotSpeed
        );
    }

    public ChassisSpeeds getSpeedsRTF(double xSpeed, double ySpeed, double rotSpeed) {
        return ChassisSpeeds.fromFieldRelativeSpeeds(
                xSpeed,
                ySpeed,
                rotSpeed,
                PoseEstimator.getInstance().getHeading()
        );
    }

    public void initSwerveDrive(ChassisSpeeds speeds) {
        SwerveModuleState[] states = KINEMATICS.toSwerveModuleStates(speeds);
        for (int i = 0; i < components.getSwerveModules().length; i++) {
            components.getSwerveModules()[i].initSwerveModule(states[i]);
        }
    }

    public void updateSwerveDrive(ChassisSpeeds speeds) {
        SwerveModuleState[] states = KINEMATICS.toSwerveModuleStates(speeds);
        for (int i = 0; i < components.getSwerveModules().length; i++) {
            components.getSwerveModules()[i].updateSwerveModule(states[i]);
        }
    }

    public ChassisSpeeds handleHumanInput(double xInput, double yInput, double rotInput, boolean driveRTF) {
        ChassisSpeeds speeds;

        double rawXSpeed = xInput * MAX_VELOCITY_MPS * DRIVE_SENSITIVITY;
        double rawYSpeed = yInput * MAX_VELOCITY_MPS * DRIVE_SENSITIVITY;
        double rawRotationSpeed = rotInput * MAX_TURNING_RAD_PS * ROTATION_SENSITIVITY;

        if (driveRTF) {
            speeds = getSpeedsRTF(
                    rawXSpeed,
                    rawYSpeed,
                    rawRotationSpeed
            );
        } else {
            speeds = getSpeedsRTR(
                    rawXSpeed,
                    rawYSpeed,
                    rawRotationSpeed
            );
        }

        return KeepAngleController.getInstance().calculate(speeds);
    }

    public void coastMode() {
        for (SwerveModule module : components.getSwerveModules()) {
            module.moduleCoast();
        }
    }

    public void breakMode() {
        for (SwerveModule module : components.getSwerveModules()) {
            module.moduleBrake();
        }
    }

    public void stopDrive() {
        for (SwerveModule module : components.getSwerveModules()) {
            module.disableModule();
        }
    }

    private static DriveTrain instance ;

    public static void init(DriveTrainComponents components) {
        if (instance == null) {
            instance = new DriveTrain(components);
        }
    }

    public static DriveTrain getInstance() {
        return instance;
    }
}
