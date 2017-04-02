package org.usfirst.frc.team4959.robot;

import org.usfirst.frc.team4959.robot.commands.Climber.RunClimber;
import org.usfirst.frc.team4959.robot.commands.Drive.Shimmy;
import org.usfirst.frc.team4959.robot.commands.GearDrop.CloseDrop;
import org.usfirst.frc.team4959.robot.commands.GearDrop.GearExtendToggle;
import org.usfirst.frc.team4959.robot.commands.GearDrop.OpenDrop;
import org.usfirst.frc.team4959.robot.commands.Shifter.ShifterToggle;
import org.usfirst.frc.team4959.robot.commands.Shooter.LoadAndShoot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public static Joystick xboxController;
	public static Joystick xboxControllertwo;
	public static Joystick joystick;
	public static boolean shimmy = false;

	public OI() {

		// ***** XBox Controller *****
		xboxController = new Joystick(RobotMap.XBOX_PORT);
		xboxControllertwo = new Joystick(RobotMap.XBOX_TWO_PORT);

		// ***** Joystick *****
		// joystick = new Joystick(RobotMap.JOYSTICK_PORT);

		// ***** Bound Buttons *****
		// Run Shooter
		Button shimmy = new JoystickButton(xboxController, RobotMap.X_BUTTON);
		shimmy.whileHeld(new Shimmy());

		Button runShooter = new JoystickButton(xboxControllertwo, RobotMap.A_BUTTON);
		runShooter.toggleWhenPressed(new LoadAndShoot());

		// // Shift Off
		// Button shifterOff = new JoystickButton(xboxController,
		// RobotMap.B_BUTTON);
		// shifterOff.whenReleased(new ShifterOff());
		//
		// // Shifter On
		// Button shifterOn = new JoystickButton(xboxController,
		// RobotMap.X_BUTTON);
		// shifterOn.whenReleased(new ShifterOn());

		// Shifter Toggle
		Button shifterToggle = new JoystickButton(xboxController, RobotMap.B_BUTTON);
		shifterToggle.whenPressed(new ShifterToggle());

		// Run Intake
		// Button runIntake = new JoystickButton(xboxController,
		// RobotMap.Y_BUTTON);
		// runIntake.whileHeld(new RunIntake());

		// Raise Climber
		Button raiseClimb = new JoystickButton(xboxControllertwo, RobotMap.B_BUTTON);
		raiseClimb.whileActive(new RunClimber(1));

		// Open Drop
		Button openDrop = new JoystickButton(xboxControllertwo, RobotMap.RIGHT_BUMPER);
		openDrop.whenPressed(new OpenDrop());
		openDrop.whenReleased(new CloseDrop());

		// Extends or Retracts the Gear Drop (First press will extend, from then
		// on will alternate)
		Button gearDropExtenderToggle = new JoystickButton(xboxControllertwo, RobotMap.LEFT_BUMPER);
		gearDropExtenderToggle.whenPressed(new GearExtendToggle());

	}

	public double getUp() {
		return xboxController.getPOV(1);
	}

	public double getDown() {
		return xboxController.getPOV(5);
	}

	// Returns the value of the Left Trigger on the XBOX Controller
	public double getLeftTrigger() {
		return xboxController.getRawAxis(RobotMap.LEFT_TRIGGER);
	}

	// Returns the value of the Right Trigger on the XBOX Controller
	public double getRightTrigger() {
		return xboxController.getRawAxis(RobotMap.RIGHT_TRIGGER);
	}

	// Returns the X-Axis value of the Left Stick on the XBOX Controller
	public double getLeftStickX() {
		return xboxController.getRawAxis(RobotMap.LEFT_X_AXIS);
	}
}
