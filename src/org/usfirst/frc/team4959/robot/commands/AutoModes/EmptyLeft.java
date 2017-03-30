package org.usfirst.frc.team4959.robot.commands.AutoModes;

import org.usfirst.frc.team4959.robot.commands.AutoCommands.Delay;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.DriveStraight;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.GyroDrive;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.GyroTurning;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.TurnToVision;
import org.usfirst.frc.team4959.robot.commands.GearDrop.CloseDrop;
import org.usfirst.frc.team4959.robot.commands.GearDrop.ExtendDrop;
import org.usfirst.frc.team4959.robot.commands.GearDrop.OpenDrop;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Drives forward then turns
 * Then uses vision to line up with the left drop 
 * Then it drives forward and drops gear at the left drop
 */ 
public class EmptyLeft extends CommandGroup {
	
	// GyroDrive(Time, Speed)
	// GyroTurning(Turn, Speed)
	// DriveStraight(Time, Speed)

	public EmptyLeft() {

		addSequential(new GyroDrive(1.53, 0.8));
		addSequential(new GyroTurning(-55, 0.6));
		addSequential(new TurnToVision());
		addSequential(new GyroDrive(1.15, 0.8));
		addSequential(new Delay(0.5));

		addSequential(new ExtendDrop());
		addSequential(new Delay(0.75));
		addSequential(new OpenDrop());
		addSequential(new Delay(1.0));
		addSequential(new DriveStraight(2.5, -0.5));
		
		addSequential(new CloseDrop());
	}
}
