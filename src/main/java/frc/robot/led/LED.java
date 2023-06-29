package frc.robot.led;

import static frc.robot.led.LEDConstants.*;

import edu.wpi.first.wpilibj.util.Color;

public class LED {

    private final LEDComponents components;

    private LED(LEDComponents components) {
        this.components = components;
    }

    private void setOneLed(int ledIndex, Color color) {
        components.getBuffer().setLED(ledIndex, color);
    }

    public void setStrip(Color color) {
        for (int ledIndex = 0; ledIndex < STRIP_LENGTH; ledIndex++)
            setOneLed(ledIndex, color);

        update();
    }

    public void setStripOff() {
        setStrip(BLACK);
    }

    public void update() {
        components.getStrip().setData(components.getBuffer());
    }

    private static LED instance;

    public static void init(LEDComponents components) {
        instance = new LED(components);
    }

    public static LED getInstance() {
        return instance;
    }
}
