package org.usfirst.frc.team4959.robot.commands.Shooter;

import org.usfirst.frc.team4959.robot.commands.Agrivator.RunAgrivator;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Runs the agrivator and shooter commands simultaneously
 */
public class LoadAndShoot extends CommandGroup {

	public LoadAndShoot() {
		addParallel(new RunAgrivator());
		addParallel(new RunShooter());
	}
}
