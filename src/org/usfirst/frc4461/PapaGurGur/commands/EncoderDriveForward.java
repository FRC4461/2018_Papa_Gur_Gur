package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;
import org.usfirst.frc4461.PapaGurGur.RobotMap;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;

import edu.wpi.first.wpilibj.command.Command;

public class EncoderDriveForward extends Command {
	private static final int COUNTS_PER_REVOLUTION = 4096;
	private static final double WHEEL_CIRCUMFERENCE = 6 * Math.PI;
	private static final double GEAR_REDUCTION = (45/19)*(50 / 14);
	private static final double COUNTS_PER_INCH = 	COUNTS_PER_REVOLUTION * GEAR_REDUCTION /
													WHEEL_CIRCUMFERENCE;
	private static final int DEAD_ZONE = (int)COUNTS_PER_INCH * 3;
	private double countsToMove;

    public EncoderDriveForward(double inchesToMove){
    	countsToMove = inchesToMove * COUNTS_PER_INCH;
    }

    
    protected void initialize() {
    	// We need to change the period for how often we send the feedback
    	// It's going to take up a lot of bandwidth if we send the info this often
		RobotMap.backLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 1);
		RobotMap.backLeft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 1);
		RobotMap.backLeft.setSelectedSensorPosition(0, 0, 1);
		RobotMap.backLeft.setSensorPhase(true);
		RobotMap.backLeft.setSafetyEnabled(false);
    	System.out.println("encoder initialize");
    }

    // The set functions MUST be in execute because motor safety is off
    // Motor safety requires that speed be set constantly
    // Also, PID is set through the website, not in code
    protected void execute() {    	
    	System.out.println("Is this actually running");
    	System.out.println("sensorPos: " + RobotMap.backLeft.getSelectedSensorPosition(0));
    	
    	Robot.driveBase.moveEncoder(countsToMove);
    	
    }

    protected boolean isFinished() {
    	if (RobotMap.backLeft.getSelectedSensorPosition(0) > countsToMove - DEAD_ZONE &&
			RobotMap.backLeft.getSelectedSensorPosition(0) < countsToMove + DEAD_ZONE) {
        	System.out.println("Done");
    		return true;
    	}
        return false;
    }

    protected void end() {
    	RobotMap.backLeft.setSafetyEnabled(true);
    	RobotMap.backRight.setInverted(false);
    	RobotMap.frontRight.setInverted(false);
    	System.out.println(RobotMap.backLeft.getSelectedSensorPosition(0));
    }

    protected void interrupted() {
    }
}
