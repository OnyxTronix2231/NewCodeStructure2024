package frc.robot.subsystems.collector;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import pid.CtreMotionMagicController;
import pid.CtrePIDController;
import pid.PIDControlMode;
import pid.PIDFTerms;
import sensors.counter.Counter;
import sensors.counter.TalonEncoder;

import static frc.robot.data.CollectorConstants.*;
import static frc.robot.data.CollectorConstants.COLLECTOR_PID.*;
import static frc.robot.data.CollectorConstants.Calculations.angleToEncoderUnits;

public class CollectorComponentsImpl implements CollectorComponents {

    private WPI_TalonFX masterMotor;
    private TalonEncoder talonEncoder;
    private final CtreMotionMagicController positionController;
    private final CtrePIDController velocityController;

    public CollectorComponentsImpl() {
        masterMotor = new WPI_TalonFX(MOTOR_ID);
        masterMotor.configFactoryDefault();
        masterMotor.configAllSettings(getTalonFXConfiguration());
        masterMotor.config_IntegralZone(0,angleToEncoderUnits(INTEGRAL_ZONE_ANGLE),0);
        masterMotor.setInverted(true);
        masterMotor.setSelectedSensorPosition(0);
        masterMotor.setNeutralMode(NeutralMode.Coast);

        talonEncoder = new TalonEncoder(masterMotor);

        positionController = new CtreMotionMagicController(masterMotor, talonEncoder,
                POSITION_CONTROLLER, ACCELERATION, CRUISE_VELOCITY, ACC_SMOOTHING);
        velocityController = new CtrePIDController(masterMotor, talonEncoder,
                new PIDFTerms(KP, KI, KD, KF), PIDControlMode.Velocity);
    }

    public TalonFXConfiguration getTalonFXConfiguration() {
        TalonFXConfiguration config = new TalonFXConfiguration();
        config.forwardSoftLimitThreshold = angleToEncoderUnits(MAX_ANGLE);
        config.forwardSoftLimitEnable = false;
        config.reverseSoftLimitThreshold = angleToEncoderUnits(MIN_ANGLE);
        config.reverseSoftLimitEnable = false;

        config.supplyCurrLimit = COLLECTOR_SUPPLY_CURRENT_LIMIT;
        return config;
    }

    @Override
    public WPI_TalonFX getMasterMotor() {
        return masterMotor;
    }

    @Override
    public Counter getEncoder() {
        return talonEncoder;
    }

    @Override
    public CtrePIDController getVelocityController() {
        return velocityController;
    }

    @Override
    public CtreMotionMagicController getPositionController() {
        return positionController;
    }
}
