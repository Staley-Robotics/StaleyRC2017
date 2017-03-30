package org.usfirst.frc.team4959.robot.subsystems;

import org.usfirst.frc.team4959.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**    
 * 
 */
public class Agrivator extends Subsystem {

	SpeedController agrivatorMoter = RobotMap.agrivatorMotor;

	public void initDefaultCommand() {
	}

	public void runAgrivator(double speed) {
		agrivatorMoter.set(speed);
	}

	public void stopAgrivator() {
		agrivatorMoter.set(0);
	}
}
