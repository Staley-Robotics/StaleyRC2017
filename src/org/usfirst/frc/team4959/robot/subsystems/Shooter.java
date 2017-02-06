package org.usfirst.frc.team4959.robot.subsystems;

import org.usfirst.frc.team4959.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Controls ball shooter on the robot
 */
public class Shooter extends Subsystem {

	SpeedController shooterMotor = RobotMap.shooterMotor;
			
	private boolean check;
	private boolean test;
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
    //Begins running the shooter and sets the speed for it
    public void runShooter(double speed) {
    	shooterMotor.set(speed);
    }
    //Turns off the motor for the shooter
    public void stopShooter() {
    	shooterMotor.set(0);
    }
    
    public boolean checkForShooting() {
    	return check;
    }
    
    public void setShooting(boolean isShooting) {
    	check = isShooting;
    }
    
    public boolean getTest() {
    	return test;
    }
    
    public void setTest(boolean sTest) {
    	test = sTest;
    }

}

