package org.usfirst.frc.team4959.robot.commands.AutoCommands;

import org.usfirst.frc.team4959.robot.Robot;
import org.usfirst.frc.team4959.robot.RobotMap;
import org.usfirst.frc.team4959.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/** 
 *  negative angle is left, positive angle is right
 */
public class GyroTurning extends Command {
	protected Gyro gyro = RobotMap.gyro;
	protected DriveTrain drive = Robot.driveTrain;

	double toAngle, speed;
	double tolerance = 1.5;
	public static double toAnglePass;

	/*
	 * angle - the target angle of the trun
	 * speed - the power sent to the speed controller
	 * toAnglePass - static variable to pass the toAngle through multiple classes as a static value
	 */
	public GyroTurning(double angle, double speed) {
		this.speed = speed;
		this.toAngle = angle;
		this.toAnglePass = angle;
		requires(Robot.driveTrain);
	}
	
	public static void gyroCap(double goalAngle, Gyro gyro2){
		if(Math.abs(goalAngle) > Math.abs(360)){
			gyro2.reset();
		}
	}


	protected void initialize() {
		gyro.reset();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Math.abs(gyro.getAngle()) > Math.abs(Math.abs(toAngle) - tolerance)
				&& (Math.abs(gyro.getAngle())) < Math.abs(Math.abs(toAngle) + tolerance)) {
		}

		if (toAngle > 0) {
			if (Math.abs(gyro.getAngle()) < Math.abs(Math.abs(toAngle) + tolerance)) {
				drive.arcadeDrive(0, -speed);
				GyroTurning.gyroCap(gyro.getAngle(), gyro);
			} else if (Math.abs(gyro.getAngle()) < Math.abs(Math.abs(toAngle) + tolerance)) {
				drive.arcadeDrive(0, speed);
				GyroTurning.gyroCap(gyro.getAngle(), gyro);
			} else {
				 drive.arcadeDrive(0, 0);
					GyroTurning.gyroCap(gyro.getAngle(), gyro);
			 }
		} else if (toAngle < 0) {
			if (Math.abs(gyro.getAngle()) < Math.abs(Math.abs(toAngle) + tolerance)) {
				drive.arcadeDrive(0, speed);
				GyroTurning.gyroCap(gyro.getAngle(), gyro);
			} else if (Math.abs(gyro.getAngle()) < Math.abs(Math.abs(toAngle) + tolerance)) {
				drive.arcadeDrive(0, -speed);
				GyroTurning.gyroCap(gyro.getAngle(), gyro);
			} else {
				drive.arcadeDrive(0, 0);
				GyroTurning.gyroCap(gyro.getAngle(), gyro);
			}
		} else {
			drive.arcadeDrive(0, 0);
			GyroTurning.gyroCap(gyro.getAngle(), gyro);
		}
		System.out.println("Angle at the end of Execute: " + gyro.getAngle());
		System.out.println("Goal: " + toAngle);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		if (Math.abs(gyro.getAngle()) > Math.abs(Math.abs(toAngle) - tolerance)
				&& (Math.abs(gyro.getAngle())) < Math.abs(Math.abs(toAngle) + tolerance)) {
			System.out.println("Turning has finished");
			return true;
		} else
			return false;
	}

	protected void end() {
		drive.stop();
		gyro.reset();
	}

	public static double getToAngle() {
		return toAnglePass;
	}
}
