package frc.robot.led;

import static frc.robot.led.LEDConstants.BLACK;
import static frc.robot.led.LEDConstants.MAX_HUE;
import static frc.robot.led.LEDConstants.RAINBOW_INDICATOR;
import static frc.robot.led.LEDConstants.RAINBOW_SATURATION;
import static frc.robot.led.LEDConstants.RAINBOW_VALUE;
import static frc.robot.led.LEDConstants.STRIP_LENGTH;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LED extends SubsystemBase {

    private int red;
    private int green;
    private int blue;

    private final LEDComponents components;

    private LED(LEDComponents components) {
        this.components = components;
    }

    public String getCurrentColor() {
        return "Red: " + red +
                " Green: " + green +
                " Blue: " + blue;
    }

    private void setOneLed(int ledIndex, int red, int green, int blue) {
        components.getBuffer().setRGB(ledIndex, red, green, blue);
    }

    public void setStrip(int red, int green, int blue) {
        for (int ledIndex = 0; ledIndex < STRIP_LENGTH; ++ledIndex)
            setOneLed(ledIndex, red, green, blue);

        this.red = red;
        this.blue = blue;
        this.green = green;

        Update();
    }

    public void setStripOff() {
        setStrip(BLACK.getRed(), BLACK.getGreen(), BLACK.getBlue());
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

        this.red = RAINBOW_INDICATOR.getRed();
        this.green = RAINBOW_INDICATOR.getGreen();
        this.blue = RAINBOW_INDICATOR.getBlue();

        Update();
    }

    public void Update() {
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
