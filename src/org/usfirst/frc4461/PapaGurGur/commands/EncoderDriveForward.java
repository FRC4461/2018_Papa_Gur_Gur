package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;
import org.usfirst.frc4461.PapaGurGur.RobotMap;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;

import edu.wpi.first.wpilibj.command.Command;

public class EncoderDriveForward extends Command {
	boolean done = false;
	int autoMove = 0;

    public EncoderDriveForward(int inches){
    	autoMove = inches;
    }
    
    protected void initialize() {
		RobotMap.backLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);
		RobotMap.backLeft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
    	System.out.println("encoder initialize");
    }

    protected void execute() {
    	System.out.println("Sensor pos: " + RobotMap.backLeft.getSelectedSensorPosition(0));
    }

    protected boolean isFinished() {
        return done;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
