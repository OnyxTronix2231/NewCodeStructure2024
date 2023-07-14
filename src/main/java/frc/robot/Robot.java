package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.Test;
import frc.robot.led.LED;
import frc.robot.led.LEDComponentsImpl;
import frc.robot.robotControl.DeputyOi;
import frc.robot.robotControl.DriverOi;
import frc.robot.subsystems.driveTrain.DriveTrain;
import frc.robot.subsystems.driveTrain.DriveTrainComponents;
import frc.robot.subsystems.driveTrain.DriveTrainComponentsImpl;
import frc.robot.subsystems.driveTrain.features.KeepAngleController;
import frc.robot.subsystems.driveTrain.features.PoseEstimator;
import frc.robot.subsystems.driveTrain.features.SwerveModule;
import sensors.Switch.Switch;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
    private DriverOi driverOi;
    private DeputyOi deputyOi;
    private DigitalInput toplimitSwitch;



    /**
     * This function is run when the robot is first started up and should be used for any
     * initialization code.
     */
    @Override
    public void robotInit() {
        DriveTrain.init(new DriveTrainComponentsImpl());
        LED.init(new LEDComponentsImpl());
        PoseEstimator.init();
        KeepAngleController.init();
        driverOi = new DriverOi();
        deputyOi = new DeputyOi();
        toplimitSwitch = new DigitalInput(9);
    }

    /**
     * This function is called every robot packet, no matter the mode. Use this for items like
     * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
     *
     * <p>This runs after the mode specific periodic functions, but before
     * LiveWindow and SmartDashboard integrated updating.
     */
    @Override
    public void robotPeriodic() {
        // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
        // commands, running already-scheduled commands, removing finished or interrupted commands,
        // and running subsystem periodic() methods.  This must be called from the robot's periodic
        // block in order for anything in the Command-based framework to work.
        CommandScheduler.getInstance().run();
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     */
    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
        if(! toplimitSwitch.get()){
            LED.getInstance().setStrip(0,255,0);
        }else {
            LED.getInstance().setStrip(255,0,0);
        }
    }

    /**
     * This autonomous runs the autonomous command.
     */
    @Override
    public void autonomousInit() {
    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() {
    }

    @Override
    public void teleopInit() {
    }

    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() {
    }

    @Override
    public void testInit() {
        // Cancels all running commands at the start of test mode.
        CommandScheduler.getInstance().cancelAll();
    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() {
    }
}
