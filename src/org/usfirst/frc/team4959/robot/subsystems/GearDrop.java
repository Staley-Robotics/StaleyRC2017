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

	DoubleSolenoid gearDrop = new DoubleSolenoid(2, 3);
	DoubleSolenoid gearDropExtender = new DoubleSolenoid(0, 1);
	Solenoid shifter = new Solenoid(4);
	Solenoid shifter2 = new Solenoid(5);
	Compressor compressor = new Compressor(0);

	public void initDefaultCommand() {
		setDefaultCommand(new RunCompressor());
	}

	// Runs the compressor until the sensor says "Stop don't run anymore" and
	// then it stops
	public void runCompressor() {
		compressor.setClosedLoopControl(true);
	}

	// Opens the Gear Drop
	public void open() {
		gearDrop.set(DoubleSolenoid.Value.kReverse);
	}

	// Closes the Gear Drop
	public void close() {
		gearDrop.set(DoubleSolenoid.Value.kForward);
	}

	// Extends the Gear Drop outward
	public void extend() {
		gearDropExtender.set(DoubleSolenoid.Value.kReverse);
	}

	// Retracts the Gear Drop inward
	public void retract() {
		gearDropExtender.set(DoubleSolenoid.Value.kForward);
	}

	// Shifts the gearbox up
	public void shifterOn() {
		shifter.set(true);
		shifter2.set(false);
	}

	// Shifts the gearbox down
	public void shifterOff() {
		shifter2.set(true);
		shifter.set(false);
	}

}
