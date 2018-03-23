package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;
import org.usfirst.frc4461.PapaGurGur.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command for driving the robot a set number of inches by using encoder counts.
 */
public class EncoderDrive extends Command {
    private static final int COUNTS_PER_REVOLUTION = 512;
    private static final double GEAR_REDUCTION = (45.0 / 19.0) * (50.0 / 14.0);
    private static final double COUNTS_PER_WHEEL_REVOLUTION = COUNTS_PER_REVOLUTION * GEAR_REDUCTION;
    private static final double WHEEL_CIRCUMFERENCE = 6 * Math.PI;
    private static final double COUNTS_PER_INCH = COUNTS_PER_WHEEL_REVOLUTION / WHEEL_CIRCUMFERENCE;

    private final static double RAMP_SPEED = 2;
    private final static double LEFT_SPEED = -0.1;
    private final static double RIGHT_SPEED = -0.1;
    
    private static final int DEFAULT_TIMEOUT = 3;

    private int countsToMove;

    private boolean isDone = false;

    /**
     * Drives forward based on inches
     *
     * @param inchesToMove
     *            The number of inches to move
     */
    public EncoderDrive(double inchesToMove) {
	this(inchesToMove, DEFAULT_TIMEOUT);
    }
    
    public EncoderDrive(double inchesToMove, int timeOutSec){
	requires(Robot.driveBase);
	countsToMove = (int) (COUNTS_PER_INCH * inchesToMove);
//	setTimeout(timeOutSec);
    }

    @Override
    protected void initialize() {
	Robot.driveBase.configEncoder();
	RobotMap.frontLeft.configClosedloopRamp(RAMP_SPEED, 0);
    }

    @Override
    protected void execute() {
	int leftEncoder = RobotMap.frontLeft.getSelectedSensorPosition(0);
	int rightEncoder = RobotMap.frontRight.getSelectedSensorPosition(0);
	
	System.out.println("Left: " + " " + leftEncoder + "Right: " + rightEncoder + " " + "Counts To Move: " + countsToMove);
	Robot.driveBase.drive(LEFT_SPEED, RIGHT_SPEED);
	if(leftEncoder >= countsToMove){
	    Robot.driveBase.stopMotors();
	    isDone = true;
	}
    }

    @Override
    protected boolean isFinished() {
	return isDone;// || isTimedOut();
    }

    @Override
    protected void end() {
	Robot.driveBase.resetMotors();
	Robot.driveBase.stopMotors();
    }

    @Override
    protected void interrupted() {
	end();
    }
}