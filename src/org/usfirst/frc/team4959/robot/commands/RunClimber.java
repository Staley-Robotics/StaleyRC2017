package org.usfirst.frc.team4959.robot.commands;

import org.usfirst.frc.team4959.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RunClimber extends Command {
	private int speed;

	public RunClimber(int speed) {
		// Use requires() here to declare subsystem dependencies
		this.speed = speed;
		requires(Robot.climber);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.climber.runClimber(speed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.climber.runClimber(0);

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.climber.runClimber(0);
	}
}
