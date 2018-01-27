
package org.usfirst.frc4461.PapaGurGur.subsystems;

import org.usfirst.frc4461.PapaGurGur.OI;
import org.usfirst.frc4461.PapaGurGur.RobotMap;
import org.usfirst.frc4461.PapaGurGur.commands.*;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveBase extends Subsystem {
	DifferentialDrive drive;
	
    public void initDefaultCommand() {
        setDefaultCommand(new Driving());
    }
	
    public DriveBase(){
		SpeedControllerGroup left = new SpeedControllerGroup(RobotMap.frontLeft, RobotMap.backLeft);
		SpeedControllerGroup right = new SpeedControllerGroup(RobotMap.frontRight, RobotMap.backRight);
    	drive = new DifferentialDrive(left,right); //4 motor drive
    }

    public void drive(double lSpeed, double rSpeed){
    	drive.tankDrive(OI.lJoyGetY(), OI.rJoyGetY());
    }
}