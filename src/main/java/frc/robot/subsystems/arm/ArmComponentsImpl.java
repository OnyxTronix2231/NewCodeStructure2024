package frc.robot.subsystems.arm;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import pid.CtreMotionMagicController;
import pid.CtrePIDController;
import pid.PIDControlMode;
import sensors.counter.TalonEncoder;

import static frc.robot.subsystems.arm.ArmConstants.*;

public class ArmComponentsImpl implements ArmComponents{
    WPI_TalonSRX armOpeningMotor;

    CtreMotionMagicController motionMagicController;

    CtrePIDController pidController;

    TalonEncoder encoder;

    public ArmComponentsImpl() {
        armOpeningMotor = new WPI_TalonSRX(1);

        motionMagicController = new CtreMotionMagicController(armOpeningMotor, encoder, positionController ,
              acceleration, cruiseVelocity, accelerationSmoothing  );

        pidController = new CtrePIDController(armOpeningMotor, encoder, velocityController, PIDControlMode.Velocity );

        encoder = new TalonEncoder(armOpeningMotor);
    }

    @Override
    public WPI_TalonSRX getOpeningMotor() {
        return armOpeningMotor;
    }
}
