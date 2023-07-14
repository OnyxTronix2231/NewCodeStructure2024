package frc.robot.subsystems.telescope;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.driveTrain.DriveTrain;
import frc.robot.subsystems.driveTrain.DriveTrainComponents;

import static frc.robot.subsystems.telescope.TelescopeConstants.Calculations.lengthToEncoderUnits;

public class Telescope extends SubsystemBase {
    private TelescopeComponents components;
    private static Telescope instance;

    public Telescope(TelescopeComponents components) {
        this.components = components;
    }

    public static Telescope getInstance() {
        return instance;
    }
    public static void initTelescope(TelescopeComponents components) {
        instance = new Telescope(components);
    }

    public void initMoveToPosition(double position, double encOffset) {
        components.getPositionController().setSetpoint(lengthToEncoderUnits(position, encOffset));
        components.getPositionController().enable();
    }

    public void updateMoveToPosition(double position, double encOffset) {
        components.getPositionController().update(lengthToEncoderUnits(position, encOffset));
    }
}
