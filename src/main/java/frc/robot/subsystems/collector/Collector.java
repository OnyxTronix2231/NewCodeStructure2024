package frc.robot.subsystems.collector;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import pid.CtreMotionMagicController;

import static frc.robot.data.CollectorConstants.Calculations.RPMToEncUnitsDecisec;
import static frc.robot.data.CollectorConstants.Calculations.angleToEncoderUnits;

public class Collector extends SubsystemBase {

    private final CollectorComponents components;

    private Collector(CollectorComponents components) {
        this.components = components;
    }

    @Override
    public void periodic() {
//        CollectorShuffleboard.getInstance().update();
    }

    public void initMoveToAngle(double angle) {
        components.getPositionController().setSetpoint(angleToEncoderUnits(angle));
        components.getPositionController().enable();
    }

    public void updateMoveToAngle(double angle) {
        components.getPositionController().update(angleToEncoderUnits(angle));
    }

    public void initMoveByRPM(double rpm) {
        components.getVelocityController().setSetpoint(RPMToEncUnitsDecisec(rpm));
        components.getVelocityController().enable();
    }

    public void updateMoveByRPM(double rpm) {
        components.getVelocityController().update(RPMToEncUnitsDecisec(rpm));
    }

    public void setSpeed(double speed) {
        components.getMasterMotor().set(speed);
    }

    public void stop() {
        setSpeed(0);
    }

    public CtreMotionMagicController getPositionController() {
        return components.getPositionController();
    }
    private static Collector instance = null;

    public static Collector getInstance() {
        return instance;
    }

    public static void init(CollectorComponents components) {
        instance = new Collector(components);
    }
}