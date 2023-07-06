package frc.robot.subsystems.elevator;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.PigeonIMU;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

public class ElevatorComponentsImpl implements ElevatorComponents {

    private WPI_TalonFX rightMasterMotor;
    private WPI_TalonFX rightFirstSlave;
    private WPI_TalonFX rightSecondSlave;

    private WPI_TalonFX leftMasterMotor;
    private WPI_TalonFX leftFirstSlave;
    private WPI_TalonFX leftSecondSlave;

    private PigeonIMU gyro;

    public ElevatorComponentsImpl() {
        rightMasterMotor = new WPI_TalonFX(8);
        rightMasterMotor.configFactoryDefault();
        rightMasterMotor.configAllSettings(getFalconConfiguration());
        rightMasterMotor.setNeutralMode((NeutralMode.Brake));

        rightFirstSlave = new WPI_TalonFX(9);
        rightFirstSlave.follow(rightMasterMotor);
        rightFirstSlave.setInverted(true);

        rightSecondSlave = new WPI_TalonFX(10);
        rightSecondSlave.follow(rightMasterMotor);
        rightSecondSlave.setInverted(true);

        leftMasterMotor = new WPI_TalonFX(5);
        leftMasterMotor.configAllSettings(getFalconConfiguration());
        leftMasterMotor.configFactoryDefault();
        leftMasterMotor.setNeutralMode((NeutralMode.Brake));

        leftFirstSlave = new WPI_TalonFX(6);
        leftFirstSlave.follow(leftMasterMotor);
        leftFirstSlave.setInverted(true);

        leftSecondSlave = new WPI_TalonFX(7);
        leftSecondSlave.follow(leftMasterMotor);
        leftSecondSlave.setInverted(true);

        gyro = new PigeonIMU(1);
    }

    public WPI_TalonFX getLeftMasterMotor() {
        return leftMasterMotor;
    }

    public PigeonIMU getGyro() {
        return gyro;
    }

    public MotorController getRightMasterMotor() {
        return rightMasterMotor;
    }
    
    public TalonFXConfiguration getFalconConfiguration() {
        TalonFXConfiguration blop = new TalonFXConfiguration();
        blop.peakOutputForward = 0.8;
        blop.peakOutputReverse = -0.7;
        blop.openloopRamp = 0.4;
        return blop;
    }
}
