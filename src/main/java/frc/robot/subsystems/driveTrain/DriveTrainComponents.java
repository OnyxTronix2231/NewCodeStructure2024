package frc.robot.subsystems.driveTrain;

import edu.wpi.first.math.kinematics.SwerveModuleState;
import frc.robot.subsystems.driveTrain.features.SwerveModule;

public interface DriveTrainComponents {

    SwerveModule[] getSwerveModules();

    SwerveModuleState[] getSwerveModuleStates();
}
