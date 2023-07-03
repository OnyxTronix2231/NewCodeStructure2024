package frc.robot.subsystems.driveTrain.features;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.Timer;

import static frc.robot.subsystems.driveTrain.DriveTrainConstants.*;

public class KeepAngleController {
    private Timer timer;
    private final PIDController keepAngleController;
    private double keepedAngle;
    private double lastRotationTIme;
    private double lastDriveTime;

    private KeepAngleController() {
        timer = new Timer();
        keepAngleController = new PIDController(
                KEEP_ANGLE_PID.getKp(),
                KEEP_ANGLE_PID.getKi(),
                KEEP_ANGLE_PID.getKd()
        );

        keepAngleController.enableContinuousInput(-Math.PI, Math.PI);
        keepedAngle = PoseEstimator.getInstance().getHeading().getDegrees();
        timer.reset();
        timer.start();
    }

    public ChassisSpeeds calculate(ChassisSpeeds chassisSpeeds) {
        double output = chassisSpeeds.omegaRadiansPerSecond;
        double currentTime = timer.get();
        if (Math.abs(chassisSpeeds.omegaRadiansPerSecond) >= MIN_TURNING_RAD_PS) {
            lastRotationTIme = currentTime;
        }
        if (Math.abs(chassisSpeeds.vxMetersPerSecond) >= MIN_VELOCITY_MPS
                || Math.abs(chassisSpeeds.vyMetersPerSecond) >= MIN_VELOCITY_MPS) {
            lastDriveTime = currentTime;
        }
        if (currentTime - lastRotationTIme < KEEP_ANGLE_ROTATION_DELAY) {
            keepedAngle = PoseEstimator.getInstance().getHeading().getRadians();
        } else if (Math.abs(chassisSpeeds.vxMetersPerSecond) >= MIN_VELOCITY_MPS
                || Math.abs(chassisSpeeds.vyMetersPerSecond) >= MIN_VELOCITY_MPS) {
            output = keepAngleController.calculate((PoseEstimator.getInstance().getHeading().getRadians()), keepedAngle);
        }

        return new ChassisSpeeds(
                chassisSpeeds.vxMetersPerSecond,
                chassisSpeeds.vyMetersPerSecond,
                output
        );
    }

    public void setKeepedAngle(Rotation2d keepedAngle) {
        this.keepedAngle = keepedAngle.getRadians();
    }

    private static KeepAngleController instance;

    // init after PoseEstimator!!!
    public static void init() {
        if (instance == null) {
            instance = new KeepAngleController();
        }
    }

    public static KeepAngleController getInstance() {
        return instance;
    }
}

