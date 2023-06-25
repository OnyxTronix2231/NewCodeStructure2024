package frc.robot.led;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;

import static frc.robot.led.LEDConstants.*;

public class LEDComponentsImpl implements LEDComponents {

    private final AddressableLED ledStrip;
    private final AddressableLEDBuffer ledBuffer;

    public LEDComponentsImpl() {
        ledStrip = new AddressableLED(LED_PORT);
        ledBuffer = new AddressableLEDBuffer(LED_STRIP_LENGTH);
    }

    @Override
    public AddressableLED getLed() {
        return ledStrip;
    }

    @Override
    public AddressableLEDBuffer getBuffer() {
        return ledBuffer;
    }
}
