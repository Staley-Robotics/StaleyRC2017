package org.usfirst.frc.team4959.robot.commands.AutoCommands;

import org.usfirst.frc.team4959.robot.Robot;
import org.usfirst.frc.team4959.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveAndTurn extends Command {
	
	private double speed;
	private double turn;
	private double speedModifier;
	private double time;
	private Timer timer = new Timer();

	protected DriveTrain drive = Robot.driveTrain;

    public DriveAndTurn(double time, double speed, double turn) {
		this.speed = speed;
		this.time = time;
		this.turn = turn;
		speedModifier = 0.96;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		timer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		//speedModifier is used to prevent veering. 
		drive.arcadeDrive(speed, turn);
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
