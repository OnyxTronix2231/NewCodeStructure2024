package frc.robot.subsystems.driveTrain;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import pid.PIDFTerms;

public class DriveTrainConstants {

    // physical values:
    public static final double WHEEL_DIAMETER = 0.09652; //IN METERS
    public static final double WHEEL_PERIMETER = WHEEL_DIAMETER * Math.PI; //IN METERS
    public static final double ROTATION_CONVERSION_RATE = 12;
    public static final double DRIVER_CONVERSION_RATE = 7.5;
    public static final double ENC_UNITS_PER_ROTATION = 2048;
    public static final int DEG_PER_ROTATION = 360;

    // --------------------------------------------------------

    // Components ID & offset:
    public static final int FRONT_RIGHT_DRIVE_MOTOR_ID = 2;
    public static final int FRONT_LEFT_DRIVE_MOTOR_ID = 5;
    public static final int BOTTOM_RIGHT_DRIVE_MOTOR_ID = 8;
    public static final int BOTTOM_LEFT_DRIVE_MOTOR_ID = 11;

    public static final int FRONT_RIGHT_TURNING_MOTOR_ID = 3;
    public static final int FRONT_LEFT_TURNING_MOTOR_ID = 6;
    public static final int BOTTOM_RIGHT_TURNING_MOTOR_ID = 9;
    public static final int BOTTOM_LEFT_TURNING_MOTOR_ID = 12;

    public static final int FRONT_RIGHT_TURNING_ENCODER_ID = 1;
    public static final int FRONT_LEFT_TURNING_ENCODER_ID = 4;
    public static final int BOTTOM_RIGHT_TURNING_ENCODER_ID = 7;
    public static final int BOTTOM_LEFT_TURNING_ENCODER_ID = 10;

    public static final double ANGLE_OFFSET_FL = 95.010 ;
    public static final double ANGLE_OFFSET_FR = 7.734 ;
    public static final double ANGLE_OFFSET_BL = 97.734 ;
    public static final double ANGLE_OFFSET_BR = 91.406 ;

    public static final int PIGEON2_ID = 0;

    // --------------------------------------------------------

    // kinematics:
    public static final double WIDTH_METERS = 0.4857;
    public static final double HEIGHT_METERS = 0.4857;
    public static final Translation2d TL_TRANSLATION = new Translation2d(WIDTH_METERS / 2, HEIGHT_METERS / 2);
    public static final Translation2d TR_TRANSLATION = new Translation2d(WIDTH_METERS / 2, -HEIGHT_METERS / 2);
    public static final Translation2d BL_TRANSLATION = new Translation2d(-WIDTH_METERS / 2, HEIGHT_METERS / 2);
    public static final Translation2d BR_TRANSLATION = new Translation2d(-WIDTH_METERS / 2, -HEIGHT_METERS / 2);

    public static final SwerveDriveKinematics KINEMATICS = new SwerveDriveKinematics(
            TL_TRANSLATION,
            TR_TRANSLATION,
            BL_TRANSLATION,
            BR_TRANSLATION
    );

    // --------------------------------------------------------

    // controllers and drive settings

    public static final double MAX_TURNING_RAD_PS = 1.5 * Math.PI;
    public static final double MAX_VELOCITY_MPS = 3;

    public static final double MIN_TURNING_RAD_PS = 0.4;
    public static final double MIN_VELOCITY_MPS = MAX_VELOCITY_MPS * 0.01;

    public static final PIDFTerms DRIVE_MOTOR_PID = new PIDFTerms(0.2, 0, 0, 1023 / 21375);
    public static final PIDFTerms TURNING_MOTOR_PID = new PIDFTerms(0.7, 0, 0, 0);
    public static final int TURNING_MOTOR_CRUISE_VEL = 17000;
    public static final int TURNING_MOTOR_ACC = 40000;
    public static final int TURNING_MOTOR_ACC_SMOOTHING = 0;

    public static final double DRIVE_SENSITIVITY = 1;
    public static final double ROTATION_SENSITIVITY = 0.7;

    public static final PIDFTerms KEEP_ANGLE_PID = new PIDFTerms(5, 0.01, 0, 0);

    public static final double KEEP_ANGLE_ROTATION_DELAY = 0.5;
    public static final double KEEP_ANGLE_DRIVE_DELAY = 0.25;

    public static final int MEDIAN_SAMPLES = 3;
    public static final int MEDIAN_SAMPLES_ROTATION = 5;
    public static final double SLEW_RATE_LIMITER_DRIVE = 2;
    public static final int SLEW_RATE_LIMITER_ROTATION = 2;

    public static final PIDFTerms AUTO_PILOT_PID_X = new PIDFTerms(1.6, 0, 0, 0);
    public static final PIDFTerms AUTO_PILOT_PID_Y = new PIDFTerms(1.6, 0, 0, 0);
    public static final PIDFTerms AUTO_PILOT_PID_ROT = new PIDFTerms(2, 0, 0, 0);
    public static double AUTO_PILOT_DRIVE_SENSITIVITY = 0.5;
    public static double AUTO_PILOT_TURNING_SENSITIVITY = 0.5;
    public static double AUTO_PILOT_DRIVE_TOLERANCE = 0.03;
    public static double AUTO_PILOT_ROTATION_TOLERANCE = Math.toRadians(5);

    public static double epdToMps(double epd) {
        return (epd * 10 * WHEEL_PERIMETER) / (ENC_UNITS_PER_ROTATION * DRIVER_CONVERSION_RATE);
    }

    public static double mpsToEpd(double mps) {
        return (mps * DRIVER_CONVERSION_RATE * ENC_UNITS_PER_ROTATION) / (10 * WHEEL_PERIMETER);
    }

    public static double degreesToEnc(double deg) {
        return ((deg * ENC_UNITS_PER_ROTATION * ROTATION_CONVERSION_RATE) / (DEG_PER_ROTATION));
    }

    public static double encToDegrees(double enc) {
        return (enc * DEG_PER_ROTATION) / (ROTATION_CONVERSION_RATE * ENC_UNITS_PER_ROTATION);
    }

    public static double EncToMeters(double enc) {
        double wheelRevs = (enc / ENC_UNITS_PER_ROTATION) / DRIVER_CONVERSION_RATE;
        double meters = wheelRevs * (WHEEL_DIAMETER * Math.PI);
        return meters;
    }

    public static SwerveModuleState optimize(SwerveModuleState target, double currentRelative) {

        double currentAbs = (currentRelative % DEG_PER_ROTATION + DEG_PER_ROTATION) % DEG_PER_ROTATION; //java is stupid so we fixed their stupid modulus.
        double d1 = target.angle.getDegrees() - currentAbs; // in 360 degrees circles there are 2 sides. this is side 1
        double d2 = DEG_PER_ROTATION - Math.abs(d1); // this is side 2

        double targetAbs = target.angle.getDegrees(); // set-point
        double speed = target.speedMetersPerSecond; //set-point speed (SwerveModuleState returns angle and speed)

        if (Math.abs(d1) > 0.25 * DEG_PER_ROTATION && Math.abs(d2) > 0.25 * DEG_PER_ROTATION) { // this function check if we can go to a closer angle and spin the wheel backwards,
            // for example if we are at 300, and we want to go to 170, we will go to 350 and spin backwards.
            targetAbs = (targetAbs + (DEG_PER_ROTATION * 0.5)) % DEG_PER_ROTATION;
            d1 = targetAbs - currentAbs;
            d2 = DEG_PER_ROTATION - Math.abs(d1);
            speed *= -1;
        }

        double rslt;

        if (Math.abs(d1) > Math.abs(d2)) { //checks who are shortest
            if (targetAbs > currentAbs) { // we had a problem that if we are at 170 deg, and we want to go to 160 deg,
                // he will go to 180 so this fixes it.
                rslt = -d2;
            } else {
                rslt = d2;
            }
        } else { // if d1 is lower so we choose him.
            rslt = d1;
        }

        return new SwerveModuleState(speed, Rotation2d.fromDegrees(currentRelative + rslt));
    }
}
