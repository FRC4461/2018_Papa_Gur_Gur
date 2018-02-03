package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;
import org.usfirst.frc4461.PapaGurGur.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;

import edu.wpi.first.wpilibj.command.Command;

public class EncoderDriveForward extends Command {
	boolean done = false;
	private static final int COUNTS_PER_REVOLUTION = 4096;
	private static final double WHEEL_CIRCUMFERENCE = 4 * Math.PI;
	private static final double GEAR_REDUCTION = 1 / 1;
	private static final double COUNTS_PER_INCH = 	COUNTS_PER_REVOLUTION * GEAR_REDUCTION /
													WHEEL_CIRCUMFERENCE;

	private double countsToMove;
	private int backLeftId = RobotMap.backLeft.getDeviceID();

    public EncoderDriveForward(int inchesToMove){
    	countsToMove = inchesToMove * COUNTS_PER_INCH;
    }
    
    public EncoderDriveForward(double inchesToMove){
    	countsToMove = inchesToMove * COUNTS_PER_INCH;
    }
    
    protected void initialize() {
    	// We need to change the period for how often we send the feedback
    	// It's going to take up a lot of bandwidth if we send the info this often
		RobotMap.backLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);
		RobotMap.backLeft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		RobotMap.backLeft.setSelectedSensorPosition(0, 0, 10);
		RobotMap.backLeft.setSafetyEnabled(false);
		
		RobotMap.backLeft.set(ControlMode.Position, countsToMove);
		RobotMap.frontLeft.set(ControlMode.Follower, backLeftId);
		RobotMap.backRight.set(ControlMode.Follower, backLeftId);
		RobotMap.frontRight.set(ControlMode.Follower, backLeftId);
		
		RobotMap.backLeft.setSensorPhase(true);
		RobotMap.backRight.setInverted(true);
		RobotMap.frontRight.setInverted(true);
	
    	System.out.println("encoder initialize");
    }

    // The set functions MUST be in execute because motor safety is off
    // Motor safety requires that speed be set constantly
    // Also, PID is set through the website, not in code
    protected void execute() {    	
    	RobotMap.backLeft.set(ControlMode.Position, countsToMove);
		RobotMap.frontLeft.set(ControlMode.Follower, backLeftId);
		RobotMap.backRight.set(ControlMode.Follower, backLeftId);
		RobotMap.frontRight.set(ControlMode.Follower, backLeftId);
    	System.out.println("Sensor pos: " + RobotMap.backLeft.getSelectedSensorPosition(0));
    }

    protected boolean isFinished() {
        return done;
    }

    protected void end() {
    	RobotMap.backLeft.setSafetyEnabled(true);
    	System.out.println(RobotMap.backLeft.getSelectedSensorPosition(0));
    }

    protected void interrupted() {
    }
}
