package org.usfirst.frc.team4959.robot.commands.Shooter;

import org.usfirst.frc.team4959.robot.Robot;
import org.usfirst.frc.team4959.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Runs the shooter motor
 */
public class RunShooter extends Command {
	//The speed at which the motor is moving/The amount of power the motor is using
	private final double SPEED = -0.9;
	
    public RunShooter() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.shooter);
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.shooter.isRunning = true;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooter.runShooter(SPEED);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
//    	Robot.shooter.stopShooter();
    	Robot.shooter.isRunning = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.shooter.stopShooter();
    }
}
