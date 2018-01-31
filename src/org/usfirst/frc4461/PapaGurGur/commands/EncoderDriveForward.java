package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;
import org.usfirst.frc4461.PapaGurGur.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class EncoderDriveForward extends Command {
	boolean done = false;
	int autoMove = 0;

    public EncoderDriveForward(int inches){
    	autoMove = inches;
    }
    
    protected void initialize() {
    }

    protected void execute() {
    	System.out.println(RobotMap.backLeft.getSelectedSensorPosition(1));
    	Robot.driveBase.moveEncoder(autoMove);
    	
    	
    	if(RobotMap.backLeft.getSelectedSensorPosition(1) >= 500){
    		done = true;
    	}
    }

    protected boolean isFinished() {
        return done;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
