package org.usfirst.frc.team4959.robot.commands.AutoCommands;

import org.usfirst.frc.team4959.robot.Robot;
import org.usfirst.frc.team4959.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
 
/**
 *	Drives straight for an amount of time
 */
public class DriveStraight extends Command {

	private double speed;
	private double speedModifier;
	private double time;
	private Timer timer = new Timer();

	protected DriveTrain drive = Robot.driveTrain;

	public DriveStraight(double time, double speed) {
		this.speed = speed;
		this.time = time;
		speedModifier = 0.96;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		timer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		//speedModifier is used to prevent veering. 
		drive.tankDrive(-speed, -speed*speedModifier);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (timer.get() > time);
	}

	// Called once after isFinished returns true
	protected void end() {
		drive.stop();
		timer.stop();
		timer.reset();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		drive.stop();
	}
}
