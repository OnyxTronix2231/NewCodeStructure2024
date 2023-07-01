package frc.robot.led;

import static frc.robot.led.LEDConstants.PORT;
import static frc.robot.led.LEDConstants.STRIP_LENGTH;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;

public class LEDComponentsImpl implements LEDComponents {

    private final AddressableLED Strip;
    private final AddressableLEDBuffer Buffer;

    public LEDComponentsImpl() {
        Strip = new AddressableLED(PORT);
        Buffer = new AddressableLEDBuffer(STRIP_LENGTH);
    }

    @Override
    public AddressableLED getStrip() {
        return Strip;
    }

    @Override
    public AddressableLEDBuffer getBuffer() {
        return Buffer;
    }
}
