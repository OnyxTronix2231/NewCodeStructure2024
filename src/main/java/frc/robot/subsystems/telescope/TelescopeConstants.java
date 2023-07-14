package frc.robot.subsystems.telescope;

import com.ctre.phoenix.motorcontrol.SupplyCurrentLimitConfiguration;
import pid.PIDFTerms;

import static frc.robot.subsystems.telescope.TelescopeConstants.ComponentsConstants.*;
import static frc.robot.subsystems.telescope.TelescopeConstants.TELESCOPE_PID.*;
import static java.lang.Math.PI;

public class TelescopeConstants {
    public static final class ComponentsConstants {

        public static final int MOTOR_ID = 1;
        public static final double MAX_ANGLE = 1500;
        public static final double MIN_ANGLE = 0;
        static final double ENCODER_UNITS_RESOLUTION = 2048;
        static final double ANG_PER_ROTATION = 360;
        static final double DECI_SECONDS_PER_MINUTE = 600;
        static final double CLOSE_LOOP_OUTPUT = 1023;
        static final int ENCODER_UNITS_PER_ROUND = 2048;
        public static final int ACCELERATION = 0;
        public static final int CRUISE_VELOCITY = 0;
        public static final int ACC_SMOOTHING = 0;
        public static final double SAFETY = 0;
        public static final double MIN_LEN = 0;
        public static final double MAX_LEN = 1000 - SAFETY;

    }
    public static class TELESCOPE_PID {

        static final double CONVERSION_RATE = 4.4;

        static final int SEC_IN_MIN = 60;
        public static final double KP = 0;
        public static final double KI = 0;
        public static final double KD = 0;
        public static final double INTEGRAL_ZONE_ANGLE = 0;
        static final double MAX_VELOCITY = 0;
        public static final double MOTOR_TO_ROLLER_RATIO = 9.6667;
        public static final double ROLLER_RADIUS = 22.4;
        public static final double ROLLER_PERIMETER = 2 * PI * ROLLER_RADIUS;
        public static final double KF = CLOSE_LOOP_OUTPUT / MAX_VELOCITY;
        public static final SupplyCurrentLimitConfiguration COLLECTOR_SUPPLY_CURRENT_LIMIT =
                new SupplyCurrentLimitConfiguration(false, 0, 0, 0);
        public static final PIDFTerms POSITION_CONTROLLER = new PIDFTerms(KP, KI, KD, 1023 / MAX_VELOCITY);
    }

    public static class Calculations {


        public static double RPMToEncUnitsDecisec(double rpm) {
            return (rpm * ENCODER_UNITS_PER_ROUND) / DECI_SECONDS_PER_MINUTE;
        }

        static double encUnitsDecisecToRPM(double encoderUnits) {
            return (encoderUnits * DECI_SECONDS_PER_MINUTE) / ENCODER_UNITS_PER_ROUND;
        }

        public static double  lengthToEncoderUnits(double length, double encOffset) {
            return ENCODER_UNITS_RESOLUTION * MOTOR_TO_ROLLER_RATIO * length / (2 * ROLLER_PERIMETER) + encOffset;
        }
    }
}
