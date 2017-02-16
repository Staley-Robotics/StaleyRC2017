package org.usfirst.frc.team4959.robot.commands.AutoModes;

import org.usfirst.frc.team4959.robot.commands.AutoCommands.DriveStraight;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.GyroDrive;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.GyroTurning;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CentGearToLeftBoiler extends CommandGroup {

    public CentGearToLeftBoiler() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	// Drive to the airship
    			addSequential(new GyroDrive(1.6, 0.4));
    			addSequential(new GyroDrive(1.0, 0.2));
    			
    			// Release Gear
    			
    			// Back up from the ariship
//    			addSequential(new Delay(0.5));
//    			addSequential(new DriveStraight(1, -0.6));
    			addSequential(new GyroDrive(0.3, -0.5));
//    			addSequential(new GyroTurning(-0.1, 0.6));

    			// 90 degree turn towards boiler direction
//    			addSequential(new Delay(.3));
    			addSequential(new GyroTurning(-93, .6));
    			
    			// Drive towards boiler direction
    			addSequential(new DriveStraight(1.7, 0.6));
    			
    			// Turn directly towards boiler
    			addSequential(new GyroTurning(-24, 0.6));
    			
    			// Drive to boiler wall
    			addSequential(new DriveStraight(1.2, 0.7));
    			addSequential(new DriveStraight(2.0, 0.4));
    			
    			// Shoot 
    			
    			// yolo it
    			
    			// skrt skrt
    			addSequential(new DriveStraight(0.5, -0.8));
    			addSequential(new GyroTurning(-24, 0.6));
    			System.out.println("Turn skrt skrt");
    			addSequential(new DriveStraight(0.3, -1.0));
    			System.out.println("skrt skrt finished");
    }
}
