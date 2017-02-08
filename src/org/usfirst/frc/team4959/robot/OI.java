package org.usfirst.frc.team4959.robot;

import org.usfirst.frc.team4959.robot.commands.Agrivator.RunAgrivator;
import org.usfirst.frc.team4959.robot.commands.Climber.RunClimber;
import org.usfirst.frc.team4959.robot.commands.GearDrop.RunGearDrop;
import org.usfirst.frc.team4959.robot.commands.Intake.RunIntake;
import org.usfirst.frc.team4959.robot.commands.Shooter.RunShooter;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);
	public static XboxController xcController;
	public static Joystick xboxController;
	public static Joystick joystick;

	public OI() {

		//    ***** X-Box Controller *****
		xboxController = new Joystick(RobotMap.XBOX_PORT);
		
        //    ***** Joystick *****
			joystick = new Joystick(RobotMap.JOYSTICK_PORT);
			
		//    ***** Bound Buttons *****

		Button raiseClimb = new JoystickButton(xboxController, RobotMap.A_BUTTON);
		raiseClimb.whileActive(new RunClimber(1));
		
		Button lowerClimb = new JoystickButton(xboxController, RobotMap.B_BUTTON);
		lowerClimb.whileHeld(new RunClimber(-1));
		
		Button runShooter = new JoystickButton(xboxController, RobotMap.X_BUTTON);
		runShooter.whileHeld(new RunShooter());
		
		Button runIntake = new JoystickButton(xboxController, RobotMap.Y_BUTTON);
		runIntake.whileHeld(new RunIntake());
		
		Button runAgrivator = new JoystickButton(xboxController, RobotMap.BACK_BUTTON);
		runAgrivator.whileActive(new RunAgrivator());
		
		Button dropGear = new JoystickButton(xboxController, RobotMap.START_BUTTON);
		dropGear.whenPressed(new RunGearDrop(3.0));
	}

	public double getUp() {
		return xboxController.getPOV(1);
	}

	public double getDown() {
		return xboxController.getPOV(5);
	}

	public double getLeftTrigger() {
		return xboxController.getRawAxis(RobotMap.LEFT_TRIGGER);
	}

	public double getRightTrigger() {
		return xboxController.getRawAxis(RobotMap.RIGHT_TRIGGER);
	}

	public double getLeftStickX() {
		return xboxController.getRawAxis(RobotMap.LEFT_X_AXIS);
	}

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
