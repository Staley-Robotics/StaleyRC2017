
package org.usfirst.frc.team4959.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4959.robot.commands.AutoCommands.Delay;
import org.usfirst.frc.team4959.robot.commands.AutoModes.AutoBrettV4;
//import org.usfirst.frc.team4959.robot.commands.AutoModes.RightGearToBoiler;
import org.usfirst.frc.team4959.robot.commands.AutoModes.CentGear;
//import org.usfirst.frc.team4959.robot.commands.AutoModes.CentGearToLeftBoiler;
//import org.usfirst.frc.team4959.robot.commands.AutoModes.CentGearToRightBoiler;
import org.usfirst.frc.team4959.robot.commands.AutoModes.EmptyLeft;
import org.usfirst.frc.team4959.robot.commands.AutoModes.LeftBoilerToLeftGear;
import org.usfirst.frc.team4959.robot.commands.AutoModes.RightBoilerToRightGear;
import org.usfirst.frc.team4959.robot.commands.AutoModes.RightGear;
//import org.usfirst.frc.team4959.robot.commands.AutoModes.LeftBoilerToLeftGear;
//import org.usfirst.frc.team4959.robot.commands.AutoModes.LeftDumpToLeftBoiler;
//import org.usfirst.frc.team4959.robot.commands.AutoModes.RightBoilerToRightGear;
//import org.usfirst.frc.team4959.robot.commands.AutoModes.RightDumpToRightBoiler;
import org.usfirst.frc.team4959.robot.commands.Climber.RunClimber;
import org.usfirst.frc.team4959.robot.subsystems.Agrivator;
import org.usfirst.frc.team4959.robot.subsystems.Climber;
import org.usfirst.frc.team4959.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4959.robot.subsystems.GearDrop;
import org.usfirst.frc.team4959.robot.subsystems.Shooter;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	// ***** Subsystems *****
	public static final GearDrop gearDrop = new GearDrop();
	public static final Agrivator agrivator = new Agrivator();
	public static final Climber climber = new Climber();
	public static final Shooter shooter = new Shooter();
	public static final DriveTrain driveTrain = new DriveTrain();
//	private UsbCamera camera;
	
	private static final int AUTO_EXPOSURE = -2;

	public static OI oi;
	protected org.usfirst.frc.team4959.robot.commands.Drive.JoystickDrive JoystickDrive;
	protected RunClimber startClimber;

	public static NetworkTable table;
	Command autonomousCommand;

	SendableChooser<Command> auto = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@SuppressWarnings("deprecation")
	@Override
	public void robotInit() {
		table = NetworkTable.getTable("LiftTracker");
		table.putDouble("ayylmao", 420);
		RobotMap.init();
		oi = new OI();

		// SmartDashboard Autonomous Choices
		auto = new SendableChooser<Command>();
		auto.addDefault("Delay", new Delay(5));
		auto.addObject("Auto Brett V4", new AutoBrettV4());
		auto.addObject("Center Gear Drop", new CentGear());
		auto.addObject("Left Gear", new EmptyLeft());
		auto.addObject("Right Gear", new RightGear());
		// auto.addObject("Center Gear to Left Boiler", new
		// CentGearToLeftBoiler());
		// auto.addObject("Right Gear to Boiler", new RightGearToBoiler());
		 auto.addObject("Right Boiler to Right Gear", new RightBoilerToRightGear());
		 auto.addObject("Left Boiler to Left Gear", new LeftBoilerToLeftGear());
		// auto.addObject("Right Dump To Right Boiler", new
		// RightDumpToRightBoiler());
		// auto.addObject("Left Dump To Left Boiler", new
		// LeftDumpToLeftBoiler());
		SmartDashboard.putData("Autonomous Modes", auto);

		// Grabs Camera feed and sends it to smart dashboard
//		camera = CameraServer.getInstance().startAutomaticCapture();
//		camera.setResolution(640, 480);
//		camera.setFPS(15);
//		camera.setExposureManual(AUTO_EXPOSURE);
		
		//Double check for shifter toggle. 
		Robot.gearDrop.shifterOff();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		
		//Turns shifter power off and retracts gear drop. 
		Robot.gearDrop.retract();
		Robot.gearDrop.shifterOff();
		
		//Sets camera exposure to AUTO_EXPOSURE not to be confused with automatic detection. 
//		camera.setExposureManual(AUTO_EXPOSURE);
		
		autonomousCommand = auto.getSelected();

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
		
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		Robot.gearDrop.retract();
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
		//Sets camera exposure to auto detect.
//		camera.setExposureAuto();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		//Sends Gyro info to smart dashboard. 
		SmartDashboard.putData("Gyro", RobotMap.gyro);
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
