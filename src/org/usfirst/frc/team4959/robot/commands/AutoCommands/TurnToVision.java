package org.usfirst.frc.team4959.robot.commands.AutoCommands;

import org.usfirst.frc.team4959.robot.Robot;
import org.usfirst.frc.team4959.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnToVision extends Command {
	Timer timer = new Timer();
	double kP = .03;
	double tierTwokP = .01;
	double currentAngle;
	boolean isGucci = false;
	double threshold = 1.5;
    public TurnToVision() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("we going baby, turning to vision");
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	currentAngle = Robot.table.getDouble("angleFromGoal");
    	if(currentAngle > 2){
    		double pOut = currentAngle * kP;
    		System.out.println(pOut);
    		Robot.driveTrain.tankDrive(-.4, .4);
    		System.out.println("we are setting left motor power");
    		
    	} else if(currentAngle < -2){
    		double pOut = currentAngle * kP;
    		System.out.println(pOut);
    		Robot.driveTrain.tankDrive(.4, -.4);
    		System.out.println("we are setting right motor power");
    		
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(currentAngle) < 2;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.arcadeDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
