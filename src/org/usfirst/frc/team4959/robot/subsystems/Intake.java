package org.usfirst.frc.team4959.robot.subsystems;

import org.usfirst.frc.team4959.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Controls ball intake on the robot.
 */
public class Intake extends Subsystem {
	
	SpeedController intakeMotor = RobotMap.intakeMotor;
	
	public void initDefaultCommand() {
    }
	
	public void runIntake(double speed) {
		intakeMotor.set(speed);
	}
	
	public void stopIntake() {
		intakeMotor.set(0);
	}
}

