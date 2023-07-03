package frc.robot.subsystems.driveTrain;

import edu.wpi.first.math.kinematics.SwerveModuleState;
import frc.robot.subsystems.driveTrain.features.SwerveModule;

import static frc.robot.subsystems.driveTrain.DriveTrainConstants.*;

public class DriveTrainComponentsImpl implements DriveTrainComponents {
    private SwerveModule[] modules;

    public DriveTrainComponentsImpl() {
        SwerveModule module_FL = new SwerveModule(
                FRONT_LEFT_DRIVE_MOTOR_ID,
                FRONT_lEFT_TURNING_MOTOR_ID,
                FRONT_LEFT_TURNING_ENCODER_ID,
                ANGLE_OFFSET_FL
        );

        SwerveModule module_FR = new SwerveModule(
                FRONT_RIGHT_DRIVE_MOTOR_ID,
                FRONT_RIGHT_TURNING_MOTOR_ID,
                FRONT_RIGHT_TURNING_ENCODER_ID,
                ANGLE_OFFSET_FR
        );

        SwerveModule module_BL = new SwerveModule(
                BOTTOM_LEFT_DRIVE_MOTOR_ID,
                BOTTOM_LEFT_TURNING_MOTOR_ID,
                BOTTOM_LEFT_TURNING_ENCODER_ID,
                ANGLE_OFFSET_BL
        );

        SwerveModule module_BR = new SwerveModule(
                BOTTOM_RIGHT_DRIVE_MOTOR_ID,
                BOTTOM_RIGHT_TURNING_MOTOR_ID,
                BOTTOM_RIGHT_TURNING_ENCODER_ID,
                ANGLE_OFFSET_BR
        );

        modules = new SwerveModule[]{
                module_FL,
                module_FR,
                module_BL,
                module_BR
        };

    }

    @Override
    public SwerveModule[] getSwerveModules() {
        return modules;
    }

    @Override
    public SwerveModuleState[] getSwerveModuleStates() {
        return null;
    }
}
