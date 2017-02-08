package org.usfirst.frc.team4959.robot.commands.AutoCommands;

import org.usfirst.frc.team4959.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForward extends Command {
	private double speed;
	private double time;
	private Timer timer = new Timer();

	protected RobotDrive drive = RobotMap.driveTrain;

	public DriveForward(double speed, double time) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		this.speed = speed;
		this.time = time;

	}

	// Called just before this Command runs the first time
	protected void initialize() {
		timer.start();

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		drive.arcadeDrive(speed, 0);

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		//System.out.println("Ryan");
		return (timer.get() > time);
	}

	// Called once after isFinished returns true
	protected void end() {
		timer.stop();
		timer.reset();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
