package org.usfirst.frc.team4959.robot.subsystems;

import org.usfirst.frc.team4959.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Controls ball shooter on the robot
 */
public class Shooter extends Subsystem {

	SpeedController shooterMotor = RobotMap.shooterMotor;

	public void initDefaultCommand() {
	}

	public void runShooter(double speed) {
		shooterMotor.set(speed);
	}

	public void stopShooter() {
		shooterMotor.set(0);
	}
}
