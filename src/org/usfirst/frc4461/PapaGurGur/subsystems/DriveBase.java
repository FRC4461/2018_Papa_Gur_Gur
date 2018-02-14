
package org.usfirst.frc4461.PapaGurGur.subsystems;

import org.usfirst.frc4461.PapaGurGur.RobotMap;
import org.usfirst.frc4461.PapaGurGur.commands.*;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveBase extends Subsystem {
	DifferentialDrive drive;
	
    public DriveBase(){
    	
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new Driving());
    }

    public void drive(double lSpeed, double rSpeed){
    	RobotMap.frontLeft.set(ControlMode.PercentOutput, -lSpeed);
    	RobotMap.backLeft.set(ControlMode.PercentOutput, -lSpeed);
    	RobotMap.frontRight.set(ControlMode.PercentOutput, rSpeed);
    	RobotMap.backRight.set(ControlMode.PercentOutput, rSpeed);
    }
    
    public void moveEncoder(double countsToMove){
    	RobotMap.backRight.setInverted(true);
    	RobotMap.frontRight.setInverted(true);
    	
    	RobotMap.backLeft.set(ControlMode.Position, countsToMove);
    	RobotMap.frontLeft.set(ControlMode.Follower, RobotMap.backLeft.getDeviceID());
    	RobotMap.frontRight.set(ControlMode.Follower, RobotMap.backLeft.getDeviceID());
    	RobotMap.backRight.set(ControlMode.Follower, RobotMap.backLeft.getDeviceID());
    }
}