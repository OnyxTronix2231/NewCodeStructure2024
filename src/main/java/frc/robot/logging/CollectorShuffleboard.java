package frc.robot.logging;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.subsystems.collector.Collector;

import static frc.robot.data.CollectorConstants.COLLECTOR_PID.POSITION_CONTROLLER;

public class CollectorShuffleboard {

    private GenericEntry kP;
    private GenericEntry kI;
    private GenericEntry kD;
    private GenericEntry kF;

    public CollectorShuffleboard(String tabName) {
        ShuffleboardTab tab = Shuffleboard.getTab(tabName);

        kP = tab.add("kP", POSITION_CONTROLLER.getKp()).getEntry();
        kI = tab.add("kI", POSITION_CONTROLLER.getKi()).getEntry();
        kD = tab.add("kD", POSITION_CONTROLLER.getKd()).getEntry();
        kF = tab.add("kF", POSITION_CONTROLLER.getKf()).getEntry();

        GenericEntry speed = tab.add("Speed", 0).getEntry();

        // tab.add("MoveBySpeed", new MoveBySpeed(()->speed.getDouble(0));
    }

    public void update() {
        Collector.getInstance().getPositionController().setPIDFTerms(
                kP.getDouble(POSITION_CONTROLLER.getKp()),
                kI.getDouble(POSITION_CONTROLLER.getKi()),
                kD.getDouble(POSITION_CONTROLLER.getKd()),
                kF.getDouble(POSITION_CONTROLLER.getKf())
        );
    }

    private static CollectorShuffleboard instance = null;

    public static CollectorShuffleboard getInstance() {
        if (instance == null) {
            instance = new CollectorShuffleboard("Collector");
        }
        return instance;
    }
}
