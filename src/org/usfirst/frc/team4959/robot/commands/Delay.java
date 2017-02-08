package org.usfirst.frc.team4959.robot.commands;

import java.sql.Time;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *STREAKS
 */
public class Delay extends Command {
	private double seconds;
	private Timer time = new Timer();

	public Delay(double seconds) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		this.seconds = seconds;
		time.reset();
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		time.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (time.get() >= seconds);
	}

	// Called once after isFinished returns true
	protected void end() {
		time.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
