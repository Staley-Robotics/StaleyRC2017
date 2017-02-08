package org.usfirst.frc.team4959.robot.subsystems;

import org.usfirst.frc.team4959.robot.commands.RunCompressor;
import org.usfirst.frc.team4959.robot.commands.GearDrop.RunGearDrop;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearDrop extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	DoubleSolenoid solenoid = new DoubleSolenoid(0,1);
	Compressor compressor = new Compressor(0);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new RunCompressor());
    }
    
    public void runCompressor() {
    	compressor.setClosedLoopControl(true);
    }
    
    public void open() {
    	solenoid.set(DoubleSolenoid.Value.kForward);
    }
    
    public void close() {
    	solenoid.set(DoubleSolenoid.Value.kReverse);
    }
}

