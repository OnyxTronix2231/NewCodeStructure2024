package frc.robot.subsystems.arm;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import pid.CtreMotionMagicController;
import pid.CtrePIDController;
import sensors.counter.TalonEncoder;

public interface ArmComponents {
    public WPI_TalonSRX getOpeningMotor();

    public CtreMotionMagicController getPositionController();

    public CtrePIDController getVelocityController();

    public TalonEncoder getEncoder();


}
