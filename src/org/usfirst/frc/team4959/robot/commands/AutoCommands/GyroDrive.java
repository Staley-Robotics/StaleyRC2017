package org.usfirst.frc.team4959.robot.commands.AutoCommands;

import org.usfirst.frc.team4959.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 * Drives straight for an amount of time using the gyro
 */
public class GyroDrive extends Command {

	private double kp = 0.03;
	private Timer timer = new Timer();
	private double time, speed;

	private Gyro gyro = RobotMap.gyro;
	private RobotDrive robotDrive = RobotMap.driveTrain;

	public GyroDrive(double time, double speed) {
		this.time = time;
		this.speed = speed;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		gyro.reset();
		timer.reset();
		timer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double currentAngle = gyro.getAngle();
		robotDrive.drive(-speed, -currentAngle * kp);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return timer.get() >= time;
	}

	// Called once after isFinished returns true
	protected void end() {
		robotDrive.drive(0, 0);
		timer.stop();
		timer.reset();
		gyro.reset();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
