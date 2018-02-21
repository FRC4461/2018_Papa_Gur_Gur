package org.usfirst.frc4461.PapaGurGur.subsystems;

import org.usfirst.frc4461.PapaGurGur.RobotMap;
import org.usfirst.frc4461.PapaGurGur.commands.Driving;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {

	private final static double STALL_CURRENT = 130;
	
	public Elevator() {
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new Driving());
    }
    
    public void configEncoder(){
    	RobotMap.elevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 1);
    	RobotMap.elevatorMotor.setSelectedSensorPosition(0, 0, 1);
    	RobotMap.elevatorMotor.setSensorPhase(true);
    	RobotMap.elevatorMotor.setSafetyEnabled(false);
    	System.out.println("Elevator Encoder Initialized");
    }
    
    public boolean isStalled(){
    	double current;    
    	current = RobotMap.elevatorMotor.getOutputCurrent();
    	return current > STALL_CURRENT;
    }
    
    public double getEncoderValue(){
    	return RobotMap.elevatorMotor.getSelectedSensorPosition(0);
    }
    
    public void stopMotor(){
    	RobotMap.elevatorMotor.set(0);
    }
    
    public void resetMotor(){
    	RobotMap.backLeft.setSafetyEnabled(true);
    	RobotMap.backRight.setInverted(false);
    	RobotMap.frontRight.setInverted(false);
    	System.out.println(RobotMap.backLeft.getSelectedSensorPosition(0));
    }
    
    public void setElevatorTarget(double targetPos){
    	RobotMap.elevatorMotor.set(targetPos);
    }
    public void setElevatorUpSpeed(double Speed) {
    	RobotMap.elevatorMotor.set(Speed);
	}
    
    public void setElevatorDownSpeed(double Speed){
    	RobotMap.elevatorMotor.set(-Speed);
    }
}

