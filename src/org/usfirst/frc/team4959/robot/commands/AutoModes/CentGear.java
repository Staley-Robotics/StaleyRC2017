package org.usfirst.frc.team4959.robot.commands.AutoModes;

import java.awt.Robot;

import org.usfirst.frc.team4959.robot.commands.AutoCommands.Delay;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.DriveStraight;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.GyroDrive;
import org.usfirst.frc.team4959.robot.commands.GearDrop.ExtendDrop;
import org.usfirst.frc.team4959.robot.commands.GearDrop.OpenDrop;
import org.usfirst.frc.team4959.robot.commands.GearDrop.ShifterOff;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Drives to the center gear and drops the gear there then backs up
 */
public class CentGear extends CommandGroup {

	public CentGear() {
		addSequential(new ShifterOff());
		addSequential(new Delay(0.1));
		addSequential(new GyroDrive(1.8, 0.45));
//		addSequential(new GyroDrive(0.25, 0.2));
		addSequential(new Delay(0.3));
		addSequential(new ExtendDrop());
		addSequential(new Delay(0.5));
		addSequential(new OpenDrop());
		addSequential(new Delay(0.5));
		addSequential(new DriveStraight(1.0, -0.5));
		addSequential(new DriveStraight(1.2, -0.6));
		// addSequential(new DriveStraight(2, 0.8));
	}
}
