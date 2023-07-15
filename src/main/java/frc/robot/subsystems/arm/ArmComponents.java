package frc.robot.subsystems.arm;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import pid.CtreMotionMagicController;
import pid.CtrePIDController;

public interface ArmComponents {
    public WPI_TalonSRX getOpeningMotor();

    public CtreMotionMagicController getPositionController();

    public CtrePIDController getVelocityController();


}
