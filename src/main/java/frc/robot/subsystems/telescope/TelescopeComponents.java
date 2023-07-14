package frc.robot.subsystems.telescope;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import pid.CtreMotionMagicController;
import sensors.counter.TalonEncoder;

public interface TelescopeComponents {

    WPI_TalonFX getMotor();

    CtreMotionMagicController getController();

    TalonEncoder getEncoder();
}
