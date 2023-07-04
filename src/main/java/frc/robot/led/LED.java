package frc.robot.led;

import static frc.robot.led.LEDConstants.*;

import edu.wpi.first.wpilibj.util.Color;

public class LED {

    private Color currentColor;

    private final LEDComponents components;

    private LED(LEDComponents components) {
        this.components = components;
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    private void setOneLed(int ledIndex, Color color) {
        components.getBuffer().setLED(ledIndex, color);
    }

    public void setStrip(Color color) {
        for (int ledIndex = 0; ledIndex < STRIP_LENGTH; ++ledIndex)
            setOneLed(ledIndex, color);
        this.currentColor = color;

        update();
    }

    public void setStripOff() {
        setStrip(BLACK);
    }

    public void setGaming(int ledJumps) {
        int hue;
        int ledOffset = 0;
        for (int ledIndex = 0; ledIndex < STRIP_LENGTH; ++ledIndex) {
            hue = (ledOffset + (ledIndex * MAX_HUE / STRIP_LENGTH)) % MAX_HUE;

            components.getBuffer().setHSV(ledIndex, hue, RAINBOW_SATURATION, RAINBOW_VALUE);
        }

        ledOffset += ledJumps;
        ledOffset %= MAX_HUE;

        currentColor =  RAINBOW_INDICATOR;
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
