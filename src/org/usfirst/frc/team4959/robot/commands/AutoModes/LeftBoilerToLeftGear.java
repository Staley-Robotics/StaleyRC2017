package org.usfirst.frc.team4959.robot.commands.AutoModes;

import org.usfirst.frc.team4959.robot.commands.AutoCommands.AutoLoadAndShoot;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.Delay;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.DriveStraight;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.GyroDrive;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.GyroTurning;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Starts at left boiler and shoots Then drives to the left gear drop to drop
 * the gear there
 */
public class LeftBoilerToLeftGear extends CommandGroup {

	// GyroDrive(Time, Speed)
	// GyroTurning(Turn, Speed)
	// DriveStraight(Time, Speed)

	public LeftBoilerToLeftGear() {

		addSequential(new AutoLoadAndShoot());
		addSequential(new DriveStraight(0.5, -0.6));
		addSequential(new GyroTurning(-131, 0.6));
		addSequential(new GyroDrive(0.85, 0.5));
		addSequential(new GyroDrive(0.2, 0.5));
		addSequential(new Delay(1.0));
		addSequential(new GyroTurning(-20, 0.6));
	}
}
