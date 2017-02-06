package org.usfirst.frc.team4959.robot.subsystems;

import org.usfirst.frc.team4959.robot.Robot;
import org.usfirst.frc.team4959.robot.RobotMap;
import org.usfirst.frc.team4959.robot.commands.Climber.RunClimber;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	SpeedController motor = RobotMap.climerMotor;

	public void initDefaultCommand() {

	}

	public void runClimber(double speed) {
		motor.set(speed);
	}	
}
