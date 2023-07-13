package frc.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.led.LED;

public class Test extends CommandBase {
    private DigitalInput toplimitSwitch;

    public Test() {
        toplimitSwitch = new DigitalInput(9);
    }

    @Override
    public void execute() {
        if(! toplimitSwitch.get()){
            LED.getInstance().setStrip(0,255,0);
        }else {
            LED.getInstance().setStrip(255,0,0);
        }
    }
}
