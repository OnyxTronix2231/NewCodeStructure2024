package frc.robot.led;

import edu.wpi.first.wpilibj.util.Color;
import static frc.robot.led.LEDConstants.*;

public class LED {
    private final LEDComponents components;

    private LED(LEDComponents components) {
        this.components = components;
    }

    private void setOneLed(int i, Color color) {
        components.getBuffer().setLED(i, color);
    }

    public void setStrip(Color color) {
        for (int i = 0; i < LED_STRIP_LENGTH; i++)
            setOneLed(i, color);

        show();
    }

    public void setStripOff() {
        setStrip(new Color(0, 0, 0));
    }

    public void show() {
        components.getLed().setData(components.getBuffer());
    }


    private static LED instance;

    public static void init(LEDComponents components) {
        instance = new LED(components);
    }

    public static LED getInstance() {
        return instance;
    }
}
