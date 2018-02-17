package org.usfirst.frc4461.PapaGurGur.subsystems;

import org.usfirst.frc4461.PapaGurGur.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {

	private double upSpeed = .3;
	private double downSpeed = .3;
	private final static double STALL_CURRENT = 130;
	
	public Elevator() {
		
	}
	
    public void initDefaultCommand() {
    	
    }
    
    public boolean isStalled(){
    	double current;
    	current = RobotMap.elevatorMotor.getOutputCurrent();
    	return current > STALL_CURRENT;
    }
    
    public void stopMotor(){
    	RobotMap.elevatorMotor.set(0);
    }
    
    public void setElevatorPositionUp() {
    	RobotMap.elevatorMotor.set(upSpeed);
	}
    
    public void setElevatorPositionDown(){
    	RobotMap.elevatorMotor.set(downSpeed);
    }
}

