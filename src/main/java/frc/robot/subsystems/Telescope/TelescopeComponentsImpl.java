package frc.robot.subsystems.Telescope;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import pid.CtreMotionMagicController;
import pid.CtrePIDController;
import pid.PIDControlMode;
import pid.PIDFTerms;
import sensors.counter.Counter;
import sensors.counter.TalonEncoder;

import static frc.robot.data.TelescopeConstant.*;

public class TelescopeComponentsImpl implements TelescopeComponents{
    private final WPI_TalonFX motor;
    private TalonEncoder talonEncoder;
    private final CtreMotionMagicController positionController;
    //private final CtrePIDController velocityController;

    public TelescopeComponentsImpl() {
        motor = new WPI_TalonFX(MOTOR_PORT);
        talonEncoder = new TalonEncoder(motor);
        positionController = new CtreMotionMagicController(motor, talonEncoder,
                POSITION_CONTROLLER, ACCELERATION, CRUISE_VELOCITY, ACC_SMOOTHING);
//        velocityController = new CtrePIDController(motor, talonEncoder,
//                new PIDFTerms(KP, KI, KD, KF), PIDControlMode.Velocity);
    }

    @Override
    public WPI_TalonFX getMotor() {
        return motor;
    }

    @Override
    public Counter getEncoder() {
        return talonEncoder;
    }

//    @Override
//    public CtrePIDController getVelocityController() {
//        return velocityController;
//    }

    @Override
    public CtreMotionMagicController getPositionController() {
        return positionController;
    }
}
