package org.usfirst.frc.team4959.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

// ***** HID Controllers *****
	public static final int XBOX_PORT = 0;
	public static final int JOYSTICK_PORT = 1;

	
// ***** HID Controller Buttons/Joysticks *****
	public static final int LEFT_X_AXIS = 0;
	public static final int LEFT_Y_AXIS = 1;
	public static final int RIGHT_X_AXIS = 4;
	public static final int RIGHT_Y_AXIS = 5;

	public static final int LEFT_TRIGGER = 2;
	public static final int LEFT_BUMPER = 5;
	public static final int RIGHT_TRIGGER = 3;
	public static final int RIGHT_BUMPER = 6;

	public static final int BACK_BUTTON = 7;
	public static final int START_BUTTON = 8;
	
	public static final int LEFT_STICK_BUTTON = 9;
	public static final int RIGHT_STICK_BUTTON = 10;

	public static final int A_BUTTON = 1;
	public static final int B_BUTTON = 2;
	public static final int X_BUTTON = 3;
	public static final int Y_BUTTON = 4;

	public static final int JOYSTICK_Y = 1;
 
	
// ***** Motor/Speed Controller Ports *****
	public static final int FRONT_LEFT_DRIVE_MOTOR_PORT = 4;
	public static final int BACK_LEFT_DRIVE_MOTOR_PORT = 5;
	public static final int FRONT_RIGHT_DRIVE_MOTOR_PORT = 0;
	public static final int BACK_RIGHT_DRIVE_MOTOR_PORT = 1;
   
	public static final int SHOOTER_MOTOR_PORT = 3;
	public static final int INTAKE_MOTOR_PORT = 2;
	public static final int AGRIVATOR_MOTOR_PORT = 6;

	public static final int CLIMBER_PORT = 7;

// ***** Speed Controllers *****
	public static SpeedController flDriveMotor = new Talon(FRONT_LEFT_DRIVE_MOTOR_PORT);
	public static SpeedController blDriveMotor = new Talon(BACK_LEFT_DRIVE_MOTOR_PORT);
	public static SpeedController frDriveMotor = new Talon(FRONT_RIGHT_DRIVE_MOTOR_PORT);
	public static SpeedController brDriveMotor = new Talon(BACK_RIGHT_DRIVE_MOTOR_PORT);

	public static SpeedController shooterMotor = new Talon(SHOOTER_MOTOR_PORT);
	public static SpeedController intakeMotor = new Talon(INTAKE_MOTOR_PORT);
	public static SpeedController agrivatorMotor = new Talon(AGRIVATOR_MOTOR_PORT);

	public static SpeedController climerMotor = new Talon(CLIMBER_PORT);

	
// ***** Other Devices *****
	public static ADXRS450_Gyro gyro = new ADXRS450_Gyro();

	
// ***** Drive Train *****
	public static RobotDrive driveTrain = new RobotDrive(flDriveMotor, blDriveMotor, frDriveMotor, brDriveMotor);

	
	// Sets Safety Enabled to False so it prevents some error. Idk what it does.
	public static void init() {
		driveTrain.setSafetyEnabled(false);
	}
}
