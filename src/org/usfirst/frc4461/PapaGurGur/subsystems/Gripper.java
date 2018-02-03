package org.usfirst.frc4461.PapaGurGur.subsystems;

import org.usfirst.frc4461.PapaGurGur.commands.Driving;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gripper extends Subsystem {
	
	public Gripper() {
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Driving());
    }
    
    public void changeGripperPosition() {
    	// if it's open, then close
    	// if it's closed, then open
    }
    
    public void intake() {
    	//run motors for certain distance
    }
}

