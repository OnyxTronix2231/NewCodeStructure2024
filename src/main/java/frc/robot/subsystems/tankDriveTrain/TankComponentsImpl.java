package frc.robot.subsystems.tankDriveTrain;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;

import static frc.robot.subsystems.tankDriveTrain.TankConstants.*;

public class TankComponentsImpl implements TankComponents{

    private TankConstants constants;
    private final WPI_TalonSRX rightMasterMotor;

    private final WPI_VictorSPX rightTopSlaveMotor;

    private final WPI_VictorSPX rightBottomSlaveMotor;
    //on the robot the battery is the back/bottom

    private final WPI_TalonSRX leftMasterMotor;

    private final WPI_VictorSPX leftTopSlaveMotor;

    private final WPI_VictorSPX leftBottomSlaveMotor;

    private final DifferentialDrive differentialDrive;

    public TankComponentsImpl(){
        rightMasterMotor = new WPI_TalonSRX(RIGHT_MASTER_ID);

        rightTopSlaveMotor = new WPI_VictorSPX(RIGHT_TOP_SLAVE_ID);
        rightTopSlaveMotor.follow(rightMasterMotor);

        rightBottomSlaveMotor = new WPI_VictorSPX(RIGHT_BOTTOM_SLAVE_ID);
        rightBottomSlaveMotor.follow(rightMasterMotor);

        leftMasterMotor = new WPI_TalonSRX(LEFT_MASTER_ID);
        leftMasterMotor.setInverted(true);

        leftTopSlaveMotor = new WPI_VictorSPX(LEFT_TOP_SLAVE_ID);
        leftTopSlaveMotor.follow(leftMasterMotor);
        leftTopSlaveMotor.setInverted(true);

        leftBottomSlaveMotor = new WPI_VictorSPX(LEFT_BOTTOM_SLAVE_ID);
        leftBottomSlaveMotor.follow(leftMasterMotor);
        leftBottomSlaveMotor.setInverted(true);


        differentialDrive = new DifferentialDrive(rightMasterMotor, leftMasterMotor);

    }

    @Override
    public MotorController getRightMasterMotor() {
        return rightMasterMotor;
    }

    @Override
    public MotorController getLeftMasterMotor() {
        return leftMasterMotor;
    }

    @Override
    public DifferentialDrive getDifferentialDrive() {
        return differentialDrive;
    }
}
