package frc.robot.test;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import frc.robot.commands.led.Blink;

public class LedShuffleboard {

    public static void init() {
        var tab = Shuffleboard.getTab("led");
        tab.add(new Blink(200, 34, 211, 1, 6));
    }
    
}
