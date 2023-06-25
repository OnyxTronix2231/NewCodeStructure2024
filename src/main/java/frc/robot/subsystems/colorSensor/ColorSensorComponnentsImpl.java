package frc.robot.subsystems.colorSensor;

import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.I2C;

public class ColorSensorComponnentsImpl implements ColorSensorComponnents{
    private final ColorSensorV3 colorSensorV3;

    public ColorSensorComponnentsImpl() {
        colorSensorV3 = new ColorSensorV3(I2C.Port.kMXP);

    }

    @Override
    public ColorSensorV3 getColorSensor() {
        return colorSensorV3;
    }
}
