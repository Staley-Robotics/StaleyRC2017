package org.usfirst.frc.team4959.robot.commands.AutoModes;

import org.usfirst.frc.team4959.robot.Robot;
import org.usfirst.frc.team4959.robot.RobotMap;
import org.usfirst.frc.team4959.robot.commands.Delay;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.AutoRunAgrivator;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.AutoRunShooter;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.GyroDrive;
import org.usfirst.frc.team4959.robot.commands.AutoCommands.GyroTurning;
import org.usfirst.frc.team4959.robot.commands.GearDrop.RunGearDrop;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Hits the gear drop, drops gear, goes to boiler and unloads balls.
 */
public class Drive extends CommandGroup {

	public Drive() {
		
		addSequential(new GyroDrive(1.5,0.5));
		addSequential(new RunGearDrop(1));
		addSequential(new GyroDrive(1,-0.5));
		addSequential(new GyroTurning(40, 0.8));
		addSequential(new Delay(1));
		addSequential(new GyroDrive(2,0.5));
		addSequential(new AutoRunAgrivator(3));
		addSequential(new AutoRunShooter(5));
	}

}