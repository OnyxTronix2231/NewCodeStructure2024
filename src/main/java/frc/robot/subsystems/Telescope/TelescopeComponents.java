package frc.robot.subsystems.Telescope;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import pid.CtreMotionMagicController;
import pid.CtrePIDController;
import sensors.counter.Counter;
import sensors.counter.TalonEncoder;

public interface TelescopeComponents {
    MotorController getMotor();
    //CtrePIDController getVelocityController();

    CtreMotionMagicController getPositionController();
    Counter getEncoder();


}
