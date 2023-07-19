package frc.robot.subsystems.offSeasonSystem;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

public class SystemComponentsComponentsImpl implements SystemComponents {
    private final WPI_TalonSRX masterMotor;

    public SystemComponentsComponentsImpl() {
        this.masterMotor = new WPI_TalonSRX(20);
        masterMotor.configFactoryDefault();
    }

    @Override
    public MotorController getMasterMotor() {
        return masterMotor;
    }
}
