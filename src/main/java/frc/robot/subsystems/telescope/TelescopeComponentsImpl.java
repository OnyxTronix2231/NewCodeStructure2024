package frc.robot.subsystems.telescope;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import pid.CtreMotionMagicController;
import sensors.counter.TalonEncoder;

import static frc.robot.data.TelescopeConstants.*;

public class TelescopeComponentsImpl implements TelescopeComponents {
    private final WPI_TalonFX motor;
    private final CtreMotionMagicController controller;
    private TalonEncoder encoder;

    public TelescopeComponentsImpl() {
        motor = new WPI_TalonFX(MOTOR_PORT);
        motor.configFactoryDefault();

        controller = new CtreMotionMagicController(motor, encoder, PIDF_TERMS, ACCELERATION, CRUISE_VELOCITY, ACC_SMOOTHING);
    }


    @Override
    public WPI_TalonFX getMotor() {
        return motor;
    }

    @Override
    public CtreMotionMagicController getController() {
        return controller;
    }

    @Override
    public TalonEncoder getEncoder() {
        return encoder;
    }
}
