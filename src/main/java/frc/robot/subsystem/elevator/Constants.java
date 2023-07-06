package frc.robot.subsystem.elevator;

public class Constants {

    public static class ComponentsConstants {

        static final int RIGHT_MASTER_ID = 5;
        static final int RIGHT_MASTER_RIGHT_SLAVE_ID = 6;
        static final int RIGHT_MASTER_LEFT_SLAVE_ID = 7;

        static final int LEFT_MASTER_ID = 8;
        static final int LEFT_MASTER_RIGHT_SLAVE_ID = 9;
        static final int LEFT_MASTER_LEFT_SLAVE_ID = 10;
        static final int GYRO_DEVICE_NUMBER = 1;
    }

    public static class Configurations {

        static final double PEAK_OUTPUT_FORWARD = 0.8;
        static final double PEAK_OUTPUT_REVERSE = -0.7;
        static final double OPEN_LOOP_RAMP = 0.4;
    }
}
