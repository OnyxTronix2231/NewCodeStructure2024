package frc.robot.Tank;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class TankComponentsImpl implements TankComponents {
    private final WPI_TalonFX leftMotor1;
    private final WPI_TalonFX leftMotor2;
    private final WPI_TalonFX leftMotor3;
    private final WPI_TalonFX rightMotor1;
    private final WPI_TalonFX rightMotor2;
    private final WPI_TalonFX rightMotor3;

    public TankComponentsImpl() {
        leftMotor1 = new WPI_TalonFX(TankConstants.LEFT_MOTOR_1);
        leftMotor2 = new WPI_TalonFX(TankConstants.LEFT_MOTOR_2);
        leftMotor3 = new WPI_TalonFX(TankConstants.LEFT_MOTOR_3);
        rightMotor1 = new WPI_TalonFX(TankConstants.RIGHT_MOTOR_1);
        rightMotor2 = new WPI_TalonFX(TankConstants.RIGHT_MOTOR_2);
        rightMotor3 = new WPI_TalonFX(TankConstants.RIGHT_MOTOR_3);
    }

    @Override
    public WPI_TalonFX getLeftMotor1() {
        return leftMotor1;
    }

    @Override
    public WPI_TalonFX getLeftMotor2() {
        return leftMotor2;
    }

    @Override
    public WPI_TalonFX getLeftMotor3() {
        return leftMotor3;
    }

    @Override
    public WPI_TalonFX getRightMotor1() {
        return rightMotor1;
    }

    @Override
    public WPI_TalonFX getRightMotor2() {
        return rightMotor2;
    }

    @Override
    public WPI_TalonFX getRightMotor3() {
        return rightMotor3;
    }

    @Override
    public void setLeftMotorsSpeed(double speed) {
        leftMotor1.set(speed);
        leftMotor2.set(speed);
        leftMotor3.set(speed);
    }

    @Override
    public void setRightMotorsSpeed(double speed) {
        rightMotor1.set(speed);
        rightMotor2.set(speed);
        rightMotor3.set(speed);
    }
}
