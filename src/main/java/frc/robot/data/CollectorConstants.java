package frc.robot.data;

import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import pid.PIDFTerms;

import static frc.robot.data.CollectorConstants.COLLECTOR_PID.CONVERSION_RATE;

public class CollectorConstants {

    public static final double MAX_ANGLE = 1500;
    public static final double MIN_ANGLE = 0;
    static final double ENCODER_UNITS_RESOLUTION = 2048;
    static final double ANG_PER_ROTATION = 360;
    static final double DECI_SECONDS_PER_MINUTE = 600;
    static final double CLOSE_LOOP_OUTPUT = 1023;
    public static final int MOTOR_ID = 16;
    static final int ENCODER_UNITS_PER_ROUND = 2048;
    public static final int ACCELERATION = 5000;
    public static final int CRUISE_VELOCITY = 3000;
    public static final int ACC_SMOOTHING = 0;

    public static class COLLECTOR_PID {

        static final double CONVERSION_RATE = 4.4;

        static final int SEC_IN_MIN = 60;
        public static final double KP = 0;
        public static final double KI = 0;
        public static final double KD = 0;
        public static final double INTEGRAL_ZONE_ANGLE = 0;
        static final double MAX_VELOCITY = 22000;
        public static final double KF = CLOSE_LOOP_OUTPUT / MAX_VELOCITY;
        public static final SupplyCurrentLimitConfiguration COLLECTOR_SUPPLY_CURRENT_LIMIT =
                new SupplyCurrentLimitConfiguration(false, 20, 25, 0.1);
        public static final PIDFTerms POSITION_CONTROLLER = new PIDFTerms(KP, KI, KD, 1023 / MAX_VELOCITY);
    }

    public static class Calculations {

        public static int angleToEncoderUnits(double angle) {
            return (int) ((angle * ENCODER_UNITS_RESOLUTION * CONVERSION_RATE) / ANG_PER_ROTATION);
        }

        public static double RPMToEncUnitsDecisec(double rpm) {
            return (rpm * ENCODER_UNITS_PER_ROUND) / DECI_SECONDS_PER_MINUTE;
        }

        static double encUnitsDecisecToRPM(double encoderUnits) {
            return (encoderUnits * DECI_SECONDS_PER_MINUTE) / ENCODER_UNITS_PER_ROUND;
        }
    }
}
