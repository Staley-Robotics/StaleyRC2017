package org.usfirst.frc.team4959.robot.commands.AutoModes;

import org.usfirst.frc.team4959.robot.commands.AutoCommands.DriveStraight;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.GyroDrive;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.GyroTurning;
import org.usfirst.frc.team4959.robot.commands.GearDrop.CloseDrop;
import org.usfirst.frc.team4959.robot.commands.GearDrop.ExtendDrop;
import org.usfirst.frc.team4959.robot.commands.GearDrop.OpenDrop;
import org.usfirst.frc.team4959.robot.commands.GearDrop.RetractDrop;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class EmptyRight extends CommandGroup {

	// GyroDrive(Time, Speed)
	// GyroTurning(Turn, Speed)
	// DriveStraight(Time, Speed)

	public EmptyRight() {

		// Drive Forward
		addSequential(new GyroDrive(1.6, 0.5));

		// Turn to gear
		addSequential(new GyroTurning(-15, 6));

		// Drive to gear
		addSequential(new DriveStraight(0.6, 0.4));

		// Drop Gear
		addSequential(new ExtendDrop());
		addSequential(new OpenDrop());
		addSequential(new RetractDrop());

		// Back up
		addSequential(new GyroDrive(0.2, -0.7));
		addParallel(new GyroTurning(-75, 0.7));
		addSequential(new GyroDrive(0.5, -0.5));
		addParallel(new CloseDrop());
		addSequential(new GyroTurning(-10, 0.1));
		addSequential(new GyroDrive(0.8, -0.6));
	}
}
