package org.usfirst.frc.team4959.robot.subsystems;

import org.usfirst.frc.team4959.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
    
/**
 * 
 */
public class Climber extends Subsystem {

	SpeedController motor = RobotMap.climerMotor;

	public void initDefaultCommand() {
	}

	public void runClimber(double speed) {
		motor.set(speed);
	}	
}
