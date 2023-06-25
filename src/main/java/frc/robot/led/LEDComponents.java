package frc.robot.led;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;

public interface LEDComponents {

    AddressableLED getLed();

    AddressableLEDBuffer getBuffer();
}
