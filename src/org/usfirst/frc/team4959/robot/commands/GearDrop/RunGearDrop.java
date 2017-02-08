package org.usfirst.frc.team4959.robot.commands.GearDrop;

import org.usfirst.frc.team4959.robot.Robot;
import org.usfirst.frc.team4959.robot.commands.Delay;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RunGearDrop extends Command {
	
	private double time;
	private Timer timer = new Timer();

    public RunGearDrop(double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.gearDrop);
    	this.time = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.gearDrop.open();
    	if (timer.get() > time) {
    		Robot.gearDrop.close();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
