package frc.robot.data;

import pid.PIDFTerms;

public class TelescopeConstants {
        public static final int MOTOR_PORT = 1;
        public static final double KP = 0;
        public static final double KI = 0;
        public static final double KD = 0;
        public static final double KF = 0;
        public static final PIDFTerms PIDF_TERMS = new PIDFTerms(KP, KI, KD, KF);
        public static final int ACCELERATION = 0;
        public static final int CRUISE_VELOCITY = 0;
        public static final int ACC_SMOOTHING = 0;
        public static final double RADIOS = 0;
        public static final double DIAMETER = RADIOS * Math.PI * 2;
        public static final double CONVERSION_RATE = 0;
        public static final double TOLERANCE = 0;

        public static class Calculations {
                public static double encToLen(int enc){
                       return ((enc * DIAMETER)/(2048 * CONVERSION_RATE)) * 2;
                }
        }
}
