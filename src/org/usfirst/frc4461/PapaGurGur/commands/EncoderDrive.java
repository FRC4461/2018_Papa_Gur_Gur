package org.usfirst.frc4461.PapaGurGur.commands;

import java.util.Optional;

import org.usfirst.frc4461.PapaGurGur.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Command for driving the robot a set number of inches by using encoder counts.
 */
public class EncoderDrive extends Command {

    private static final int DEFAULT_TIMEOUT = 3;

    private double countsToMove;

    private boolean isDone = false;

    private double leftSpeed;
    private double rightSpeed;

    private double countsPerInch;

    /**
     * Drives forward based on inches
     *
     * @param inchesToMove
     *            The number of inches to move
     */
    public EncoderDrive(double inchesToMove) {
	this(inchesToMove, DEFAULT_TIMEOUT);
    }

    public EncoderDrive(double inchesToMove, int timeOutSec) {
	requires(Robot.driveBase);

	countsToMove = countsPerInch * inchesToMove;

	setTimeout(timeOutSec);
    }

    /*
     * Make factory function and overload them to make code clearer and more
     * readable
     */
    public static EncoderDrive GoForwardInches(double inchesToMove, Optional<Integer> timeOutSec) {
	return new EncoderDrive(inchesToMove, timeOutSec.orElse(DEFAULT_TIMEOUT));
    }

    public static EncoderDrive GoBackInches(double inchesToMove, Optional<Integer> timeOutSec) {
	return new EncoderDrive(-inchesToMove, timeOutSec.orElse(DEFAULT_TIMEOUT));
    }

    @Override
    protected void initialize() {
	leftSpeed = Robot.driveBase.getLeftSpeed();
	rightSpeed = Robot.driveBase.getRightSpeed();
	countsPerInch = Robot.driveBase.getCountsPerInch();

	Robot.driveBase.configEncoder();
	Robot.driveBase.setDrivingRamp();
    }

    @Override
    protected void execute() {
	int leftEncoder = Robot.driveBase.getFrontLeftEncoderValue();
	int rightEncoder = Robot.driveBase.getFrontRightEncoderValue();

	System.out.println(
		"Left: " + " " + leftEncoder + "Right: " + rightEncoder + " " + "Counts To Move: " + countsToMove);
	Robot.driveBase.drive(leftSpeed, rightSpeed);
	if (leftEncoder >= countsToMove && -rightEncoder >= countsToMove) {
	    Robot.driveBase.stopMotors();
	    isDone = true;
	}
    }

    @Override
    protected boolean isFinished() {
	return isDone || isTimedOut();
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
