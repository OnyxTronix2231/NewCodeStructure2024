package frc.robot.subsystems.concept;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class ConceptComponentsImpl implements ConceptComponents{
    private final WPI_TalonSRX yaniv;

    public ConceptComponentsImpl() {
        this.yaniv = new WPI_TalonSRX(14);
        yaniv.configFactoryDefault();
    }

    @Override
    public WPI_TalonSRX getYaniv() {
        return yaniv;
    }
}
