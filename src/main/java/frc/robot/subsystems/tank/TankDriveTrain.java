package frc.robot.subsystems.tank;

import edu.wpi.first.wpilibj.Joystick;

public class TankDriveTrain {
    private final Joystick controller;
    private final TankComponents tankComponents;

    public TankDriveTrain(Joystick controller, TankComponents tankComponents) {
        this.controller = controller;
        this.tankComponents = tankComponents;
    }

    public void teleopPeriodic() {
        double forward = -controller.getRawAxis(TankConstants.LEFT_JOYSTICK_AXIS_Y);
        double turn = controller.getRawAxis(TankConstants.RIGHT_JOYSTICK_AXIS_X);

        double leftSpeed = forward + turn;
        double rightSpeed = forward - turn;

        tankComponents.setLeftSpeed(leftSpeed);
        tankComponents.setRightSpeed(rightSpeed);
    }
}