package frc.robot.Tank;

import edu.wpi.first.wpilibj.Joystick;

public class Tank {
    private final Joystick controller;
    private final TankComponents tankComponents;

    public Tank(Joystick controller, TankComponents tankComponents) {
        this.controller = controller;
        this.tankComponents = tankComponents;
    }

    public void teleopPeriodic() {
        double forward = -controller.getRawAxis(TankConstants.LEFT_JOYSTICK_AXIS_Y);
        double turn = controller.getRawAxis(TankConstants.RIGHT_JOYSTICK_AXIS_X);

        double leftSpeed = forward + turn;
        double rightSpeed = forward - turn;

        tankComponents.setLeftMotorsSpeed(leftSpeed);
        tankComponents.setRightMotorsSpeed(rightSpeed);
    }
}