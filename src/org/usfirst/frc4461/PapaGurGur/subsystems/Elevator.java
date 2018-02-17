package org.usfirst.frc4461.PapaGurGur.subsystems;

import org.usfirst.frc4461.PapaGurGur.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {

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
    
    public void setElevatorUpSpeed(double Speed) {
    	RobotMap.elevatorMotor.set(Speed);
	}
    
    public void setElevatorDownSpeed(double Speed){
    	RobotMap.elevatorMotor.set(-Speed);
    }
}

