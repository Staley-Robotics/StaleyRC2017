package org.usfirst.frc.team4959.robot.commands.AutoModes;

import org.usfirst.frc.team4959.robot.commands.AutoCommands.AutoLoadAndShoot;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.DriveStraight;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.GyroDrive;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.GyroTurning;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Starts at left boiler and shoots
 * Then drives to the left gear drop to drop the gear there
 */
public class LeftBoilerToLeftGear extends CommandGroup {
	
	// GyroDrive(Time, Speed)
	// GyroTurning(Turn, Speed)
	// DriveStraight(Time, Speed)

	public LeftBoilerToLeftGear() {

		// Turn into the boiler (Drive straight and let it curve into it)
//		addSequential(new GyroTurning(15, 0.4));
		addSequential(new DriveStraight(0.3, -0.5));
		
		// Shoot
		addSequential(new AutoLoadAndShoot());
		
//		// Turn out of the wall
		addSequential(new GyroTurning(20, 0.6));

		// Back up about a foot
		addSequential(new GyroDrive(0.5, 0.5));

		// Turn around just under 180
		addSequential(new GyroTurning(167, 0.7));
		
		// Track Tape Near Gear Drop Location
//		addSequential(new GetVisionAngle());
//		
//		addSequential(new GyroTurning(-Robot.driveTrain.gyroStore, 0.6));

		// Drive Straight in the direction of the right gear
		addSequential(new DriveStraight(0.6, 0.5));
	}
}
