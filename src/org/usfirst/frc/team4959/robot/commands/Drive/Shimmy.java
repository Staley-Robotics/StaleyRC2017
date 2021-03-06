package org.usfirst.frc.team4959.robot.commands.Drive;

import org.usfirst.frc.team4959.robot.commands.AutoCommands.DriveAndTurn;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.DriveStraight;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Used to shimmy onto the geardrop
 */
public class Shimmy extends CommandGroup {

	public Shimmy() {
		// Add Commands here:
		// e.g. addSequential(new Command1());
		// addSequential(new Command2());
		// these will run in order.

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		// addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.
		addSequential(new ShimmyToggle(true));
		addSequential(new DriveStraight(0.3, -0.5));
		addSequential(new DriveStraight(0.4, 0.5));
		addSequential(new DriveAndTurn(0.2, 0.0, 0.4));
		addSequential(new DriveAndTurn(0.2, 0.0, -0.4));
		addSequential(new ShimmyToggle(false));

	}
}
