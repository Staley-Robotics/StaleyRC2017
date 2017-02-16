package org.usfirst.frc.team4959.robot.subsystems;

import org.usfirst.frc.team4959.robot.commands.GearDrop.RunCompressor;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearDrop extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	DoubleSolenoid openGear = new DoubleSolenoid(0, 1);
	DoubleSolenoid outLeft = new DoubleSolenoid(2, 3);
	DoubleSolenoid outRight = new DoubleSolenoid(4, 5);
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
    	outRight.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void retract() {
    	outLeft.set(DoubleSolenoid.Value.kForward);
    	outRight.set(DoubleSolenoid.Value.kForward);
    }
}

