package org.usfirst.frc.team4959.robot.subsystems;

import org.usfirst.frc.team4959.robot.commands.GearDrop.RunCompressor;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearDrop extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	DoubleSolenoid openGear = new DoubleSolenoid(0, 1);
	DoubleSolenoid outLeft = new DoubleSolenoid(2, 3);
	Solenoid dropOut = new Solenoid(4);
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
    	openGear.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void close() {
    	openGear.set(DoubleSolenoid.Value.kForward);
    }
    
    public void extend() {
    	outLeft.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void retract() {
    	outLeft.set(DoubleSolenoid.Value.kForward);
    }
    
    public void shifterOn() {
    	dropOut.set(true);
    }
    
    public void shifterOff() {
    	dropOut.set(false);
    }
}

