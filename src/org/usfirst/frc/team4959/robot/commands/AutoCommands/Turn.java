package org.usfirst.frc.team4959.robot.commands.AutoCommands;

import org.usfirst.frc.team4959.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Turns the robot for an amount of time
 */

public class Turn extends Command {

	private double turnSpeed;
	public double time;
	private Timer timer;

	protected RobotDrive drive = RobotMap.driveTrain;

	public Turn(double turnSpeed, double time) {
		this.turnSpeed = turnSpeed;
		this.time = time;

		timer = new Timer();
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		timer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		drive.arcadeDrive(0, turnSpeed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (timer.get() > time);
	}

	// Called once after isFinished returns true
	protected void end() {
		timer.stop();
		timer.reset();
	}
}
