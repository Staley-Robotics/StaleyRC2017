package org.usfirst.frc.team4959.robot.commands.Agrivator;
 
import org.usfirst.frc.team4959.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Activates agrivator which prepares balls to be shot by the shooter.
 */  
public class RunAgrivator extends Command {

	private final double SPEED = -0.16;

	public RunAgrivator() { 
		requires(Robot.agrivator);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.agrivator.runAgrivator(SPEED);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.agrivator.stopAgrivator();
	}
}
