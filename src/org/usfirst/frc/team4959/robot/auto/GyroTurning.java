package org.usfirst.frc.team4959.robot.auto;

import org.usfirst.frc.team4959.robot.Robot;
import org.usfirst.frc.team4959.robot.RobotMap;
import org.usfirst.frc.team4959.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4959.robot.utill.JMath;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 ***************
 * I Broke it * - julien *
 ***************
 * 
 */
public class GyroTurning extends Command {
	protected Gyro gyro = RobotMap.gyro;
	protected DriveTrain drive = Robot.driveTrain;

	double toAngle, speed;
	double tolerance = 0.1;
	private boolean isTurning = false;

	public GyroTurning(double angle, double speed) {
		// Use requires() het to declare subsystem dependencies
		this.speed = JMath.clamp(speed, 0.6, 1);
		this.toAngle = angle;
		requires(Robot.driveTrain);
		//setInputRange(0,360);
		

	}
	
	// STREAKS.
	// Called just before this Command runs the first time
	protected void initialize() {
		//setSetpoint(toAngle);
		gyro.reset();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		System.out.println("Excecute : " + gyro.getAngle() + " to" + toAngle);
		if (Math.abs(gyro.getAngle()) >= Math.abs(toAngle)) {
			isTurning = true;
			drive.arcadeDrive(0, 0);
		}
		if (Math.abs(gyro.getAngle()) > Math.abs(toAngle)) {
			drive.arcadeDrive(0, speed);
		} else if (Math.abs(gyro.getAngle()) < Math.abs(toAngle)) {
			drive.arcadeDrive(0, -speed);
		} else {
			drive.arcadeDrive(0, 0);
			isTurning = true;
		}		
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		System.out.println(gyro.getRate());
		return isTurning;
	}

	protected void end() {
		drive.stop();
		System.out.println("Has Ended");
		
	}
	//Above does gyro turns.
	

	

}
