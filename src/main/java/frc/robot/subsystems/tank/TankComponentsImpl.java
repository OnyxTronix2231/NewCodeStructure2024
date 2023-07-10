package frc.robot.subsystems.tank;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class TankComponentsImpl implements TankComponents {
    private final WPI_TalonSRX leftMaster;
    private final VictorSPX leftSlave1;
    private final VictorSPX leftSlave2;
    private final WPI_TalonSRX rightMaster;
    private final VictorSPX rightSlave1;
    private final VictorSPX rightSlave2;



    public TankComponentsImpl() {
        leftMaster = new WPI_TalonSRX(TankConstants.LEFT_MASTER_MOTOR);
        leftSlave1 = new VictorSPX(TankConstants.LEFT_SLAVE1_MOTOR);
        leftSlave2 = new VictorSPX(TankConstants.LEFT_SLAVE2_MOTOR);
        rightMaster = new WPI_TalonSRX(TankConstants.RIGHT_MASTER_MOTOR);
        rightSlave1 = new VictorSPX(TankConstants.RIGHT_SLAVE1_MOTOR);
        rightSlave2 = new VictorSPX(TankConstants.RIGHT_SLAVE2_MOTOR);


        // Set inversion for the motors on one side
        leftMaster.setInverted(false);
        leftSlave1.setInverted(false);
        leftSlave2.setInverted(false);
        rightMaster.setInverted(false);
        rightSlave1.setInverted(false);
        rightSlave2.setInverted(false);


        // Set the slave motors to follow the master motors
        leftSlave1.follow(leftMaster);
        leftSlave2.follow(leftMaster);
        rightSlave1.follow(rightMaster);
        rightSlave2.follow(rightMaster);
    }

    @Override
    public WPI_TalonSRX getLeftMotor1() {
        return leftMaster;
    }

    @Override
    public VictorSPX getLeftMotor2() {
        return leftSlave1;
    }

    @Override
    public VictorSPX getLeftMotor3() {
        return leftSlave2;
    }

    @Override
    public WPI_TalonSRX getRightMotor1() {
        return rightMaster;
    }

    @Override
    public VictorSPX getRightMotor2() {
        return rightSlave1;
    }

    @Override
    public VictorSPX getRightMotor3() {
        return rightSlave2;
    }




    public void setLeftSpeed(double speed) {
        leftMaster.set(speed);
    }

    public void setRightSpeed(double speed) {
        rightMaster.set(speed);
    }
}
