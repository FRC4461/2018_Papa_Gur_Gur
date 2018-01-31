
package org.usfirst.frc4461.PapaGurGur.subsystems;

import org.usfirst.frc4461.PapaGurGur.RobotMap;
import org.usfirst.frc4461.PapaGurGur.commands.*;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveBase extends Subsystem {
	DifferentialDrive drive;
	
    public void initDefaultCommand() {
        setDefaultCommand(new Driving());
    }
	
    public DriveBase(){
    	
    }

    public void drive(double lSpeed, double rSpeed){
    	RobotMap.frontLeft.set(ControlMode.PercentOutput, lSpeed);
    	RobotMap.backLeft.set(ControlMode.PercentOutput, lSpeed);
    	RobotMap.frontRight.set(ControlMode.PercentOutput, rSpeed);
    	RobotMap.backRight.set(ControlMode.PercentOutput, rSpeed);

    }
    
    public void moveEncoder(int autoMove){
    	RobotMap.backLeft.setSelectedSensorPosition(0, 0, 0);
    	RobotMap.backLeft.setSelectedSensorPosition(autoMove, 0, 1);
    }
}