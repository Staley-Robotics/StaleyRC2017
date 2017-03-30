package org.usfirst.frc.team4959.robot.commands.AutoModes;

import org.usfirst.frc.team4959.robot.commands.AutoCommands.Delay;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.DriveStraight;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.GyroDrive;
import org.usfirst.frc.team4959.robot.commands.GearDrop.ExtendDrop;
import org.usfirst.frc.team4959.robot.commands.GearDrop.OpenDrop;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Drives to the center gear and drops the gear there then backs up
 */
public class CentGear extends CommandGroup {

	public CentGear() {

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
