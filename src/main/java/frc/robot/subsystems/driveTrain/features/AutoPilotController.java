package frc.robot.subsystems.driveTrain.features;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.subsystems.driveTrain.DriveTrain;

import static frc.robot.subsystems.driveTrain.DriveTrainConstants.*;

public class AutoPilotController {
    private PIDController controllerX;
    private PIDController controllerY;
    private PIDController controllerRot;
    private Pose2d targetPose;
    private PoseEstimator poseEstimator;
    private DriveTrain driveTrain;
    private Pose2d deltaPose;

    public AutoPilotController(Pose2d deltaPose) {
        ShuffleboardTab tab = Shuffleboard.getTab("PoseEstimator");
        tab.addNumber("errorX",()->controllerX.getPositionError());
        tab.addNumber("errorY",()->controllerY.getPositionError());
        tab.addNumber("errorRot",()->controllerRot.getPositionError());

        controllerX = new PIDController(
                AUTO_PILOT_PID_X.getKp(),
                AUTO_PILOT_PID_X.getKi(),
                AUTO_PILOT_PID_X.getKd()
        );
        controllerY = new PIDController(
                AUTO_PILOT_PID_Y.getKp(),
                AUTO_PILOT_PID_Y.getKi(),
                AUTO_PILOT_PID_Y.getKd()
        );
        controllerRot = new PIDController(
                AUTO_PILOT_PID_ROT.getKp(),
                AUTO_PILOT_PID_ROT.getKi(),
                AUTO_PILOT_PID_ROT.getKd()
        );
        controllerRot.enableContinuousInput(-Math.PI, Math.PI);

        driveTrain = DriveTrain.getInstance();
        poseEstimator = PoseEstimator.getInstance();
        this.deltaPose = deltaPose;
    }

    public ChassisSpeeds initController() {
        Pose2d currentPose = poseEstimator.getPose2d();
        targetPose = new Pose2d(
                currentPose.getX() + deltaPose.getX(),
                currentPose.getY() + deltaPose.getY(),
                currentPose.getRotation().plus(deltaPose.getRotation())
        );

        controllerX.setSetpoint(targetPose.getX());
        controllerY.setSetpoint(targetPose.getY());
        controllerRot.setSetpoint(targetPose.getRotation().getRadians());

        double valueX = controllerX.calculate(currentPose.getX());
        double valueY = controllerX.calculate(currentPose.getY());
        double valueRot = controllerX.calculate(currentPose.getRotation().getRadians());

        return getLimitedSpeeds(valueX, valueY, valueRot);
    }

    public ChassisSpeeds updateController() {
        Pose2d currentPose = poseEstimator.getPose2d();

        double valueX = controllerX.calculate(currentPose.getX());
        double valueY = controllerY.calculate(currentPose.getY());
        double valueRot = controllerRot.calculate(currentPose.getRotation().getRadians());

        return getLimitedSpeeds(valueX, valueY, valueRot);
    }

    public ChassisSpeeds getLimitedSpeeds(double xSpeed, double ySpeed, double rotSpeed) {
        return driveTrain.getSpeedsRTF(
                MathUtil.clamp(xSpeed, -MAX_VELOCITY_MPS * AUTO_PILOT_DRIVE_SENSITIVITY, MAX_VELOCITY_MPS * DRIVE_SENSITIVITY),
                MathUtil.clamp(ySpeed, -MAX_VELOCITY_MPS * AUTO_PILOT_DRIVE_SENSITIVITY, MAX_VELOCITY_MPS * DRIVE_SENSITIVITY),
                MathUtil.clamp(rotSpeed, -MAX_TURNING_RAD_PS * AUTO_PILOT_TURNING_SENSITIVITY, MAX_TURNING_RAD_PS * ROTATION_SENSITIVITY)
        );
    }

    public boolean isFinished() {
        return Math.abs(controllerRot.getPositionError()) <= AUTO_PILOT_ROTATION_TOLERANCE &&
                Math.abs(controllerX.getPositionError()) <= AUTO_PILOT_DRIVE_TOLERANCE &&
                Math.abs(controllerY.getPositionError()) <= AUTO_PILOT_DRIVE_TOLERANCE;
    }
}
