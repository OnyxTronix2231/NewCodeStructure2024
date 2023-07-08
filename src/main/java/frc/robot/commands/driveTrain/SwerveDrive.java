package frc.robot.commands.driveTrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.driveTrain.DriveTrain;
import frc.robot.subsystems.driveTrain.features.DriveInputFilters;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import static frc.robot.subsystems.driveTrain.DriveTrainConstants.*;


public class SwerveDrive extends CommandBase {
    private final DriveTrain driveTrain;
    private final DoubleSupplier inputXSupplier;
    private final DoubleSupplier inputYSupplier;
    private final DoubleSupplier inputRotSupplier;
    private final BooleanSupplier isRTFSupplier;
    private DriveInputFilters driveInputFiltersX;
    private DriveInputFilters driveInputFiltersY;
    private DriveInputFilters driveInputFiltersRot;


    public SwerveDrive(DoubleSupplier inputXSupplier, DoubleSupplier inputYSupplier, DoubleSupplier inputRotSupplier, BooleanSupplier isRTFSupplier) {
        this.driveTrain = DriveTrain.getInstance();
        this.inputXSupplier = inputXSupplier;
        this.inputYSupplier = inputYSupplier;
        this.inputRotSupplier = inputRotSupplier;
        this.isRTFSupplier = isRTFSupplier;

        driveInputFiltersX = new DriveInputFilters(SLEW_RATE_LIMITER_DRIVE, MEDIAN_SAMPLES);
        driveInputFiltersY = new DriveInputFilters(SLEW_RATE_LIMITER_DRIVE, MEDIAN_SAMPLES);
        driveInputFiltersRot = new DriveInputFilters(SLEW_RATE_LIMITER_ROTATION, MEDIAN_SAMPLES_ROTATION);

        addRequirements(driveTrain);
    }

    @Override
    public void initialize() {
        driveTrain.initSwerveDrive(
                driveTrain.handleHumanInput(
                        driveInputFiltersX.calculate(inputXSupplier.getAsDouble()),
                        driveInputFiltersY.calculate(inputYSupplier.getAsDouble()),
                        driveInputFiltersRot.calculate(inputRotSupplier.getAsDouble()),
                        isRTFSupplier.getAsBoolean()
                )
        );
    }

    @Override
    public void execute() {
        driveTrain.updateSwerveDrive(
                driveTrain.handleHumanInput(
                        driveInputFiltersX.calculate(inputXSupplier.getAsDouble()),
                        driveInputFiltersY.calculate(inputYSupplier.getAsDouble()),
                        driveInputFiltersRot.calculate(inputRotSupplier.getAsDouble()),
                        isRTFSupplier.getAsBoolean()
                )
        );
    }

    @Override
    public void end(boolean interrupted) {
        driveTrain.stopDrive();
    }
}
