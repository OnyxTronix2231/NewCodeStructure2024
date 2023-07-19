package frc.robot.subsystems.concept;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class ConceptComponentsImpl implements ConceptComponents{
    private final WPI_TalonSRX yaniv;
    private final WPI_TalonSRX slaveYaniv;

    public ConceptComponentsImpl() {
        this.yaniv = new WPI_TalonSRX(14 );
        yaniv.configFactoryDefault();

        this.slaveYaniv = new WPI_TalonSRX(15);
        slaveYaniv.follow(yaniv);
        slaveYaniv.setInverted(true);
    }

    @Override
    public WPI_TalonSRX getYaniv() {
        return yaniv;
    }
}
