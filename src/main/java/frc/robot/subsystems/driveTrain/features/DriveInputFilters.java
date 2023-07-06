package frc.robot.subsystems.driveTrain.features;

import edu.wpi.first.math.filter.MedianFilter;
import edu.wpi.first.math.filter.SlewRateLimiter;

public class DriveInputFilters {
    private SlewRateLimiter slewRateLimiter;
    private MedianFilter medianFilter;

    public DriveInputFilters(double rateLimit, int medianSamples) {
        slewRateLimiter = new SlewRateLimiter(rateLimit);
        medianFilter = new MedianFilter(medianSamples);
    }

    public double calculate(double input) {
        return slewRateLimiter.calculate(medianFilter.calculate(input));
    }
}
