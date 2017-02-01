package org.usfirst.frc.team4959.robot.auto;

import org.usfirst.frc.team4959.robot.Robot;
import org.usfirst.frc.team4959.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Drive extends CommandGroup {

	public Drive() {

		/*
		 * addSequential(new DriveForward(0.5, 4.5)); addSequential(new
		 * DriveForward(-0.5, 2)); addSequential(new Turn(-0.55,1.6));
		 * 
		 * addSequential(new DriveForward(0.6, 3.4));
		 * 
		 * addSequential(new DriveForward(-0.5, 2));
		 * 
		 * addSequential(new Turn(0.72,1.3));
		 * 
		 * addSequential(new DriveForward(0.5, 5));
		 * 
		 * addSequential(new DriveForward(-0.5, 2));
		 * 
		 * 
		 * addSequential(new Turn(0.85,1.1)); addSequential(new
		 * DriveForward(0.5, 4));
		 * 
		 * 
		 * addSequential(new Turn(0.5, 1));
		 * 
		 * addSequential(new DriveForward(0.5, 2));
		 * 
		 * addSequential(new Turn(-0.5, 1));
		 * 
		 * addSequential(new DriveForward(0.5, 1));
		 * 
		 */

		// addSequential(new Delay(5));

		// addSequential(new GyroTurning(-45, 0.6));
		// addSequential(new DriveForward(0.5, 0.5));
		// addSequential(new GyroTurnning(90, 0.6));

		// Julia's code
		/*
		 * addSequential(new DriveForward(0.5, 0.5)); addSequential(new
		 * Turn(-0.5, 2)); //so like, negative is turn right, positive is turn
		 * left addSequential(new DriveForward(0.5, 0.9)); addSequential(new
		 * DriveForward(0.5, 3.5)); addSequential(new Turn(0.75, .75));
		 * addSequential(new DriveForward(0.5, 3.5));
		 */
		 addSequential(new DriveForward( 0.5, 2));
		 addSequential(new Turn(-0.5, 2));
		 addSequential(new DriveForward(0.5, 3.8));
		 addSequential(new Turn(0.75, 0.75));
		 addSequential(new DriveForward(0.5, 6.5));
		 addSequential(new Turn(0.75, 0.85));
		 addSequential(new DriveForward(0.5, 5));
		 addSequential(new Turn(-0.45,0.75));
		 addSequential(new DriveForward(0.5,3));
		 addSequential(new Turn(0.75, 0.75));
		 addSequential(new DriveForward(0.5, 3));
		 //All above is for moving (forward/backward, turning)
		 

		//addParallel(new GyroTurning(180, 0.6));

	}

}
