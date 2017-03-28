package org.usfirst.frc.team4959.robot.commands.AutoModes;

import org.usfirst.frc.team4959.robot.commands.AutoCommands.Delay;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.DriveStraight;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.GyroDrive;
import org.usfirst.frc.team4959.robot.commands.GearDrop.ExtendDrop;
import org.usfirst.frc.team4959.robot.commands.GearDrop.OpenDrop;
import org.usfirst.frc.team4959.robot.commands.GearDrop.ShifterOff;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoBrettv3 extends CommandGroup {

	public AutoBrettv3() {
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

		addSequential(new GyroDrive(2.2, 0.65));
		addSequential(new Delay(0.5));
		addSequential(new ExtendDrop());
		addSequential(new Delay(1));
		addSequential(new OpenDrop());
		addSequential(new Delay(1.75));
		addSequential(new DriveStraight(2.0, -0.5));
		addSequential(new DriveStraight(2.7, -0.6));
		// addSequential(new DriveStraight(2, 0.8));
	}
}
