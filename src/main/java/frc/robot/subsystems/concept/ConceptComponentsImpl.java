package frc.robot.subsystems.concept;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class ConceptComponentsImpl implements ConceptComponents{
    private final WPI_TalonSRX yaniv;
    private final WPI_TalonSRX yahel;

    public ConceptComponentsImpl() {
        this.yaniv = new WPI_TalonSRX(14);
        yaniv.configFactoryDefault();
        this.yahel = new WPI_TalonSRX(15);
        yahel.configFactoryDefault();
    }

    @Override
    public WPI_TalonSRX getYaniv() {
        return yaniv;
    }

    @Override
    public WPI_TalonSRX getRightYaniv() {
        return yahel;
    }
}
