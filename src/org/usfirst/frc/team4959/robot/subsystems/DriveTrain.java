package org.usfirst.frc.team4959.robot.subsystems;

import org.usfirst.frc.team4959.robot.RobotMap;
import org.usfirst.frc.team4959.robot.commands.JoystickDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	RobotDrive drive = RobotMap.driveTrain;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	double angle;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new JoystickDrive(1));
    }
    
    public void driveStraight(double move) {
		drive.arcadeDrive(move * 0.9, move);
	}

	public void arcadeMovement(Joystick j) {
		drive.arcadeDrive(j.getThrottle(), 0);
	}
	
	public void xboxTankDrive(double left, double right){
		drive.tankDrive(left, right);
	}
	
	public void worldOfTanksDrive(double forward, double backward, double rotate) {
		double speedModifier = 0.95;
		double turnSpeedModifier = 1;
		
		if(backward * speedModifier > 0) {
			drive.arcadeDrive(-backward * speedModifier, rotate * turnSpeedModifier);
		} else if (forward > 0) {
			drive.arcadeDrive(forward * speedModifier, -rotate * turnSpeedModifier);
		} else {
			drive.arcadeDrive(0, -rotate * turnSpeedModifier); 
		}
	}
	
	public void turn(double turn) {
		drive.tankDrive(turn, -turn);
	}

	public void stop() {
		drive.drive(0, 0);
	}
}

