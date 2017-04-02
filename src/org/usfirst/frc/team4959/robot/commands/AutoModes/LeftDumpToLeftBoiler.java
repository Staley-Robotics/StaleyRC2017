package org.usfirst.frc.team4959.robot.commands.AutoModes;

import org.usfirst.frc.team4959.robot.commands.AutoCommands.AutoLoadAndShoot;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.Delay;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.DriveStraight;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.GyroTurning;
import org.usfirst.frc.team4959.robot.commands.Shifter.ShifterOn;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Goes to the left dump to load balls Then goes back and shoots into the left
 * boiler
 */
public class LeftDumpToLeftBoiler extends CommandGroup {

	public LeftDumpToLeftBoiler() {
		// Turn Shifter On
		addSequential(new ShifterOn());
		addSequential(new DriveStraight(0.1, -0.1));

		// *Get to Dump Location*
		// Back Up
		addParallel(new DriveStraight(0.82, 0.7));
		// Turn Slightly Towards Dump
		addSequential(new GyroTurning(33, 0.6));
		// Back up more
		addSequential(new DriveStraight(0.6, 0.55));
		// Turn to where back is facing Dump
		addSequential(new GyroTurning(40, 0.6));
		// Back into the Dump
		addSequential(new DriveStraight(0.4, 0.7));
		addSequential(new DriveStraight(0.2, 0.4));

		// Dump
		addSequential(new Delay(2.75));

		// *Back away from Dump and Line Up With Boiler*
		// Back Up
		addSequential(new DriveStraight(0.5, -0.5));
		// Turn slightly
		addSequential(new GyroTurning(-15, 0.6));
		// Back Up More
		addSequential(new DriveStraight(1.0, -0.65));
		// Turn to line up with Boiler
		addSequential(new GyroTurning(-91, 0.6));

		// Drive to Boiler
		addSequential(new DriveStraight(0.65, -0.7));
		addSequential(new DriveStraight(0.1, 0));
		addSequential(new DriveStraight(0.15, -0.2));
		addSequential(new DriveStraight(0.5, 0));

		// Shoot
		addSequential(new AutoLoadAndShoot());
	}
}
