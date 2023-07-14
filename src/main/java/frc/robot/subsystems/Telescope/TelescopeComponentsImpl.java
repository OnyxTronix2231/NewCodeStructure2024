package frc.robot.subsystems.Telescope;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import static frc.robot.data.ElevatorConstant.RIGHT_MASTER_MOTOR_PORT;
import static frc.robot.data.TelescopeConstant.*;

public class TelescopeComponentsImpl implements TelescopeComponents{
    private final WPI_TalonFX motor;

    public TelescopeComponentsImpl() {
        motor = new WPI_TalonFX(MOTOR_PORT);
    }

    @Override
    public WPI_TalonFX getMotor() {
        return motor;
    }
}
