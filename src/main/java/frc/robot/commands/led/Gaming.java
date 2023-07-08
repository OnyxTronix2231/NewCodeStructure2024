package frc.robot.commands.led;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.led.LED;

public class Gaming extends CommandBase {

    private LED led;
    private int jumps;

    public Gaming(int jumps) {
        this.led = LED.getInstance();
        this.jumps = jumps;
        addRequirements(led);
    }

    @Override
    public void execute() {
        led.setGaming(jumps);
    }

    @Override
    public void end(boolean interrupted) {
        led.setStripOff();
    }
}
