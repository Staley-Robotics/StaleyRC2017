package org.usfirst.frc.team4959.robot.auto;

import java.awt.GradientPaint;

import org.usfirst.frc.team4959.robot.Robot;
import org.usfirst.frc.team4959.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 *
 */
public class GyroDrive extends Command {
	private Gyro gyro = RobotMap.gyro;
	private RobotDrive robotDrive = RobotMap.driveTrain;
	private double kp = 0.03;
	private Timer timer = new Timer();
	private double time, speed;

	public GyroDrive(double time, double speed) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		this.time = time;
		this.speed = speed;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		gyro.reset();
		timer.start();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double currentAngle = gyro.getAngle();
		robotDrive.drive(speed, -currentAngle * kp);
		//if(currentAngle <-2 || currentAngle>2)
			//robotDrive.drive(speed, -currentAngle * kp);
		//if angle != something within 2 degrees of 0, speed, -currentAngle *kp
		System.out.println("Angle: " + currentAngle);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return timer.get() >= time;
	}

	// Called once after isFinished returns true
	protected void end() {
		//gyro.reset(); booty cheecks at programming so we do this
		//I think that it should be at both the start and the end.
		robotDrive.drive(0, 0);

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
