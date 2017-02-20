package org.usfirst.frc.team4959.robot.commands.AutoModes;

import org.usfirst.frc.team4959.robot.commands.AutoCommands.AutoLoadAndShoot;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.Delay;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.DriveStraight;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.GyroDrive;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.GyroTurning;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftDumpToLeftBoiler extends CommandGroup {

	public LeftDumpToLeftBoiler() {
		// Parallel GyroDrive and GyroTurning into the Dump Location
		addParallel(new DriveStraight(0.78, -0.8));
		addSequential(new GyroTurning(-40, 0.5));
		addSequential(new DriveStraight(0.5, -0.6));
		addSequential(new GyroTurning(-30, 0.5));
		addSequential(new DriveStraight(0.7, -0.5));

		// Dump
		addSequential(new Delay(2.5));

		// Parallel GyroDrive and GyroTurning to back up and line up with Boiler
		addSequential(new DriveStraight(0.6, 0.5));
		addSequential(new GyroTurning(15, 0.5));
		addSequential(new DriveStraight(0.8, 0.6));
		addSequential(new GyroTurning(115, 0.5));

		// Drive to Boiler
		addSequential(new GyroDrive(1.0, 0.6));

		// Shoot
		 addSequential(new AutoLoadAndShoot());
	}
}
