package frc.robot.Elevator;

import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.PigeonIMU;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

public class ElevatorComponentsImpl implements ElevatorComponents {
    private final WPI_TalonFX leftMasterMotor;

    private final WPI_TalonFX rightMasterMotor;

    private final WPI_TalonFX topLeftSlaveMotor;

    private final WPI_TalonFX topRightSlaveMotor;

    private final WPI_TalonFX bottomLeftSlaveMotor;

    private final WPI_TalonFX bottomRightSlaveMotor;

    private final PigeonIMU gyro;

    ElevatorComponentsImpl(){
        leftMasterMotor = new WPI_TalonFX(5);

        topLeftSlaveMotor = new WPI_TalonFX(6);

        bottomLeftSlaveMotor = new WPI_TalonFX(7);

        rightMasterMotor = new WPI_TalonFX(8);

        topRightSlaveMotor = new WPI_TalonFX(9);

        bottomRightSlaveMotor = new WPI_TalonFX(10);

        gyro = new PigeonIMU(1);
    }


    @Override
    public MotorController getLeftMasterMotor() {
        return leftMasterMotor;
    }

    @Override
    public MotorController getRightMasterMotor() {
        return rightMasterMotor;
    }

    @Override
    public MotorController getLeftSlaverMotor() {
        return topLeftSlaveMotor;
    }

    @Override
    public MotorController getRightSlaveMotor() {
        return topRightSlaveMotor;

    }

    @Override
    public PigeonIMU getGyro() {
        return gyro;
    }
    public TalonFXConfiguration getFalconConfiguration(){
        TalonFXConfiguration talonConfig = new TalonFXConfiguration();
        talonConfig.peakOutputForward = 0.8;
        talonConfig.peakOutputReverse = -0.7;
        talonConfig.openloopRamp = 0.4;
        return talonConfig;
    }
}
