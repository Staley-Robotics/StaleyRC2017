package org.usfirst.frc.team4959.robot;

import org.usfirst.frc.team4959.robot.subsystems.Climber;

import edu.wpi.first.wpilibj.AnalogGyro;
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
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;

	// Controllers

	public static final int XBOX_PORT = 0;
	public static final int JOYSTICK_PORT = 1;

	public static final int LEFT_X_AXIS = 0;
	public static final int LEFT_Y_AXIS = 1;
	public static final int RIGHT_X_AXIS = 4;
	public static final int RIGHT_Y_AXIS = 5;

	public static final int LEFT_TRIGGER = 2;
	public static final int LEFT_BUMPER = 6;
	public static final int RIGHT_TRIGGER = 3;
	public static final int RIGHT_BUMPER = 8;

	public static final int A_BUTTON = 1;
	public static final int B_BUTTON = 2;
	public static final int X_BUTTON = 3;

	public static final int Y_BUTTON = 4;

	public static final int JOYSTICK_Y = 1;

	// Ports

	public static final int FRONT_LEFT_DRIVE_MOTOR_PORT = 1;
	public static final int BACK_LEFT_DRIVE_MOTOR_PORT = 2;
	public static final int FRONT_RIGHT_DRIVE_MOTOR_PORT = 3;
	public static final int BACK_RIGHT_DRIVE_MOTOR_PORT = 4;

	public static final int GYRO_PORT = 0;

	public static final int CLIMBER_PORT = 8;

	// Speed Controller Deceleration

	public static SpeedController flDriveMotor = new Talon(FRONT_LEFT_DRIVE_MOTOR_PORT);
	public static SpeedController blDriveMotor = new Talon(BACK_LEFT_DRIVE_MOTOR_PORT);
	public static SpeedController frDriveMotor = new Talon(FRONT_RIGHT_DRIVE_MOTOR_PORT);
	public static SpeedController brDriveMotor = new Talon(BACK_RIGHT_DRIVE_MOTOR_PORT);

	public static SpeedController climerMotor = new Talon(CLIMBER_PORT);
	// Drive Train

	public static RobotDrive driveTrain = new RobotDrive(flDriveMotor, blDriveMotor, frDriveMotor, brDriveMotor);

	public static AnalogGyro gyro = new AnalogGyro(GYRO_PORT);

	public static void init() {
		driveTrain.setSafetyEnabled(false);
	}

}
