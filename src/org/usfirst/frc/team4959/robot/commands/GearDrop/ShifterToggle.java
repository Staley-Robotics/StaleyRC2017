package org.usfirst.frc.team4959.robot.commands.GearDrop;

import org.usfirst.frc.team4959.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShifterToggle extends Command {

	private static boolean shifterToggle;
	private final String TAG = "Shifter: ";

    public ShifterToggle() {
    }

    // Called just before this Command runs the first time
    protected void initialize() { 
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (shifterToggle) {
    		Robot.gearDrop.shifterOn();
    	}
    	else {
    		Robot.gearDrop.shifterOff();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	if (shifterToggle) {
    		System.out.println(TAG + "Shifter on End");
    	}
    	else {
    		System.out.println(TAG + "Shifter off End");
    	}
    	
    	shifterToggle = !shifterToggle;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
 
    	
    }
}
