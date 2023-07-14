package frc.robot.subsystems.telescope;

import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class TelescopeComponnentsImpl implements TelescopeComponents{
    private final WPI_TalonSRX masterMotor;

    public TelescopeComponnentsImpl() {
        this.masterMotor = new WPI_TalonSRX(1);
        masterMotor.configFactoryDefault();
        masterMotor.configAllSettings(getTalonFxconfig());
    }

    @Override
    public WPI_TalonSRX getMasterMotor() {
        return null;
    }
    private TalonSRXConfiguration getTalonFxconfig() {
        TalonSRXConfiguration config = new TalonSRXConfiguration();
        return config;
    }
}
