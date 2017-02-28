package org.usfirst.frc.team4959.robot.subsystems;

import org.usfirst.frc.team4959.robot.RobotMap;
import org.usfirst.frc.team4959.robot.commands.Drive.JoystickDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/** 
 * Controls basic drive functionality of the robot
 */
public class DriveTrain extends Subsystem {
	
	public double gyroStore = 0.0;
	
	RobotDrive drive = RobotMap.driveTrain;

	public void initDefaultCommand() {
		setDefaultCommand(new JoystickDrive(1));
	}

	public void arcadeDrive(double forward, double turn){
		drive.arcadeDrive(forward, turn);
	}

	public void tankDrive(double left, double right) {
		drive.tankDrive(left, right);
	}

	public void worldOfTanksDrive(double backward, double forward, double rotate) {
		double speedModifier = 1;
		double turnSpeedModifier = 1;
		
		if (backward * speedModifier > 0) {
			drive.arcadeDrive(-backward * speedModifier, rotate * turnSpeedModifier);
		} else if (forward > 0) {
			drive.arcadeDrive(forward * speedModifier, rotate * turnSpeedModifier);
		} else {
			drive.arcadeDrive(0, rotate * turnSpeedModifier);
		}
	}

	public void turn(double turn) {
		drive.tankDrive(turn, -turn);
	}

	public void stop() {
		drive.drive(0, 0);
	}
}
