package frc.robot.subsystem.elevator.commads;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystem.elevator.Elevator;

import javax.swing.text.View;

public class MoveToNigger extends CommandBase {

    private Elevator elevator;

    public MoveToNigger() {
        elevator = Elevator.getInstance();
    }

    @Override
    public void execute() {
        if (elevator.getFusedHeading() == 69) {
            for (int i = 0; i < 69; i++) {
                System.out.println("Nigger");
            }
        }
    }
}
