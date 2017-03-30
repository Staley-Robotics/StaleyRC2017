package org.usfirst.frc.team4959.robot.commands.AutoModes;

import org.usfirst.frc.team4959.robot.commands.AutoCommands.DriveStraight;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Drives straight forward (Because apparently this is all Brett could make it do)
 */
public class AutoBrettV4 extends CommandGroup {

    public AutoBrettV4() {
    	addSequential(new DriveStraight(2.0, 0.7));
    }
}
