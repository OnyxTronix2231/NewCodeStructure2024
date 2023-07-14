package frc.robot.subsystems.arm;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class ArmComponentsImpl implements ArmComponents{
    WPI_TalonSRX armOpeningMotor;

    @Override
    public WPI_TalonSRX getOpeningMotor() {
        return armOpeningMotor;
    }
}
