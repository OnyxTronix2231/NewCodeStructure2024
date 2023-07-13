package frc.robot.subsystems.telescope;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import static frc.robot.data.TelescopeConstants.*;

public class TelescopeComponentsImpl implements TelescopeComponents {
    private final WPI_TalonFX motor;

    public TelescopeComponentsImpl() {
        motor = new WPI_TalonFX(MOTOR_PORT);
        motor.configFactoryDefault();
    }


    @Override
    public WPI_TalonFX getMotor() {
        return motor;
    }
}
