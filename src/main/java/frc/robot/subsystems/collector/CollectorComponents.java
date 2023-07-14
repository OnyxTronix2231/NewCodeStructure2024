package frc.robot.subsystems.collector;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import pid.CtreMotionMagicController;
import pid.CtrePIDController;
import sensors.counter.Counter;

public interface CollectorComponents {

    WPI_TalonFX getMasterMotor();

    CtrePIDController getVelocityController();

    CtreMotionMagicController getPositionController();

    Counter getEncoder();
}