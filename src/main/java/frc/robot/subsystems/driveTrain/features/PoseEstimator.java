package frc.robot.subsystems.driveTrain.features;

import com.ctre.phoenix.sensors.WPI_Pigeon2;
import edu.wpi.first.math.estimator.SwerveDrivePoseEstimator;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.logging.DriveTrainShuffleBoard;
import frc.robot.subsystems.driveTrain.DriveTrain;

import static frc.robot.subsystems.driveTrain.DriveTrainConstants.*;

public class PoseEstimator extends SubsystemBase {
    private final DriveTrain driveTrain;
    private final ShuffleboardTab tab = Shuffleboard.getTab("PoseEstimator");
    private WPI_Pigeon2 pigeon;
    private SwerveDrivePoseEstimator swerveDrivePoseEstimator;
    private final Field2d currentPose = new Field2d();

    public PoseEstimator() {
        driveTrain = DriveTrain.getInstance();

        this.pigeon = new WPI_Pigeon2(PIGEON2_ID);

        this.swerveDrivePoseEstimator = new SwerveDrivePoseEstimator(
                KINEMATICS,
                pigeon.getRotation2d(),
                driveTrain.getSwerveModulesPosition(),
                new Pose2d()
        );
        tab.addString("Pose", this::getFormattedPose).withPosition(0, 0).withSize(2, 0);
        tab.add("Field", currentPose).withPosition(2, 0).withSize(6, 4);
    }

    @Override
    public void periodic() {
        swerveDrivePoseEstimator.update(
                pigeon.getRotation2d(),
                driveTrain.getSwerveModulesPosition()
        );
        currentPose.setRobotPose(getPose2d());
    }

    public Pose2d getPose2d() {
        return swerveDrivePoseEstimator.getEstimatedPosition();
    }

    public void setPose2d(Pose2d currentPose) {
        swerveDrivePoseEstimator.resetPosition(
                pigeon.getRotation2d(),
                driveTrain.getSwerveModulesPosition(),
                currentPose
        );
        KeepAngleController.getInstance().setKeepedAngle(getHeading());
    }

    private String getFormattedPose() {
        var pose = getPose2d();
        return String.format("(%.2f, %.2f) %.2f degrees",
                pose.getX(),
                pose.getY(),
                pose.getRotation().getDegrees());
    }

    public Rotation2d getHeading() {
        return getPose2d().getRotation();
    }

    private static PoseEstimator instance;

    //pose estimator init will come after drivetrain init,
    // because if you do otherwise, drivetrain will not exist in robotinit, code will crash
    public static void init() {
        if (instance == null) {
            instance = new PoseEstimator();
        }
    }

    public static PoseEstimator getInstance() {
        return instance;
    }
}
