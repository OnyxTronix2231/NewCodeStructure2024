package frc.robot.subsystems.telescope;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public interface TelescopeComponents {
    WPI_TalonSRX getMasterMotor();
}
