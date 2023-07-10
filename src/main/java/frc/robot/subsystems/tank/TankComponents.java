package frc.robot.subsystems.tank;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public interface TankComponents {
    WPI_TalonSRX getLeftMotor1();
    VictorSPX getLeftMotor2();
    VictorSPX getLeftMotor3();
    WPI_TalonSRX getRightMotor1();
    VictorSPX getRightMotor2();
    VictorSPX getRightMotor3();



    void setLeftSpeed(double speed);
    void setRightSpeed(double speed);
}
