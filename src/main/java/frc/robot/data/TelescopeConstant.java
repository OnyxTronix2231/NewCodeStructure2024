package frc.robot.data;

import pid.PIDFTerms;

public class TelescopeConstant {
    static final double CLOSE_LOOP_OUTPUT = 1023;
    static final double MAX_VELOCITY = 22000;
    public static final int MOTOR_PORT = 11;
    public static final double KP = 0;
    public static final double KI = 0;
    public static final double KD = 0;
    public static final double KF = CLOSE_LOOP_OUTPUT / MAX_VELOCITY;
    public static final int ACCELERATION = 5000;
    public static final int CRUISE_VELOCITY = 3000;
    public static final int ACC_SMOOTHING = 0;
    public static final PIDFTerms POSITION_CONTROLLER = new PIDFTerms(KP, KI, KD, 1023 / MAX_VELOCITY);


}
