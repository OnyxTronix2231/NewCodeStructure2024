package frc.robot.subsystems.arm;

import pid.PIDFTerms;

public class ArmConstants {

    public static final PIDFTerms velocityController = new PIDFTerms(0.0, 0, 0, 0);

    public static final PIDFTerms positionController = new PIDFTerms(0.0, 0, 0, 0);

    public static final int acceleration = 0;

    public  static final int cruiseVelocity = 0;

    public static final int accelerationSmoothing = 0;



}
