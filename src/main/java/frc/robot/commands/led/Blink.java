package frc.robot.commands.led;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.led.LED;

import static frc.robot.led.LEDConstants.BLACK;

public class BlinkOnce extends SequentialCommandGroup {

    private final LED led;

    public BlinkOnce(int red, int green, int blue, double blinkDelays) {
        led = LED.getInstance();
        addRequirements(led);
        addCommands(
                new InstantCommand(()-> led.setStrip(red, green, blue)),
                new WaitCommand(blinkDelays),
                new InstantCommand(()-> led.setStrip(BLACK.getRed(), BLACK.getGreen(), BLACK.getBlue())),
                new WaitCommand(blinkDelays)
        );
    }
}
