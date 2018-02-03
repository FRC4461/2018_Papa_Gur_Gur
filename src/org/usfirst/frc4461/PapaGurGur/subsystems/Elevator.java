package org.usfirst.frc4461.PapaGurGur.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Elevator() {
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setElevatorPosition() {
    	
	}
    
    public enum elevatorPositions {
    	SWITCH, LOSING, NEUTRAL, WINNING
    }
}

