package frc.robot.Tank;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public interface TankComponents {
    WPI_TalonFX getLeftMotor1();
    WPI_TalonFX getLeftMotor2();
    WPI_TalonFX getLeftMotor3();
    WPI_TalonFX getRightMotor1();
    WPI_TalonFX getRightMotor2();
    WPI_TalonFX getRightMotor3();

    void setLeftMotorsSpeed(double speed);
    void setRightMotorsSpeed(double speed);
}
