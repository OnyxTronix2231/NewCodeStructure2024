package frc.robot.logging;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.commands.WaitCommandSupplier;

import java.util.function.DoubleSupplier;

public class TestShuffleBoard {
    private ShuffleboardTab tab;
    private DoubleSupplier duration;

    public TestShuffleBoard(){
        tab = Shuffleboard.getTab("test");

        tab.add("duration", duration).getEntry();
        tab.add("WaitCommandSupplier", new WaitCommandSupplier(duration));
    }
}
