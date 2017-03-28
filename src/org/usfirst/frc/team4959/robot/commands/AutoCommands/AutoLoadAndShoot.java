package org.usfirst.frc.team4959.robot.commands.AutoCommands;

import org.usfirst.frc.team4959.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
 
/**
 *	Runs the RunShooter and RunAgrivator for an amount of time
 */
public class AutoLoadAndShoot extends Command {
	private Timer timer = new Timer();
	private double time = 5;
	private final double SHOOTER_SPEED = -0.94;
	private final double AGRIVATOR_SPEED = -0.15;

	public AutoLoadAndShoot() {
		timer.reset();
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		timer.start();
		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.agrivator.runAgrivator(AGRIVATOR_SPEED);
		Robot.shooter.runShooter(SHOOTER_SPEED);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (timer.get() > time);	
}

	// Called once after isFinished returns true
	protected void end() {
		timer.stop();
		Robot.agrivator.stopAgrivator();
		Robot.shooter.stopShooter();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.agrivator.stopAgrivator();
		Robot.shooter.stopShooter();
	}
}
