package frc.robot.subsystems.telescope;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import pid.CtreMotionMagicController;
import pid.CtrePIDController;
import sensors.counter.Counter;

public interface TelescopeComponents {
    MotorController getMotor();

    CtrePIDController getVelocityController();

    CtreMotionMagicController getPositionController();

    Counter getEncoder();

}
