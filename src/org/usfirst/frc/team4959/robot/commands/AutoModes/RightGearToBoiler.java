package org.usfirst.frc.team4959.robot.commands.AutoModes;

import org.usfirst.frc.team4959.robot.commands.AutoCommands.Delay;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.GyroDrive;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.GyroTurning;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Drops gear on right gear drop then drives to right boiler and shoots
 */
public class RightGearToBoiler extends CommandGroup {

	// GyroDrive(Time, Speed)
	// GyroTurning(Turn, Speed)
	// DriveStraight(Time, Speed)

	public RightGearToBoiler() {
		addSequential(new GyroDrive(1.3, 0.6));
		addSequential(new GyroTurning(60, 0.6));
		addSequential(new Delay(1));
		addSequential(new GyroTurning(-60, 0.6));
		addSequential(new Delay(1));
		addSequential(new GyroTurning(60, 0.6));
	}
}
