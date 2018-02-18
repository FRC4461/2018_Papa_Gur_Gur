package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;
import org.usfirst.frc4461.PapaGurGur.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class EncoderDrive extends Command {
	private static final int COUNTS_PER_REVOLUTION = 4096;
	private static final double WHEEL_CIRCUMFERENCE = 6 * Math.PI;
	private static final double GEAR_REDUCTION = (45 / 19) * (50 / 14);
	private static final double COUNTS_PER_INCH = COUNTS_PER_REVOLUTION * GEAR_REDUCTION / WHEEL_CIRCUMFERENCE;
	private static final int DEAD_ZONE = (int) COUNTS_PER_INCH * 3;
	private double countsToMove;

	private EncoderDrive(double inchesToMove) {
		requires(Robot.driveBase);
		countsToMove = inchesToMove * COUNTS_PER_INCH;
	}

	public static EncoderDrive goForwardInches(double inchesToMove) {
		return new EncoderDrive(inchesToMove);
	}

	public static EncoderDrive goBackwardInches(double inchesToMove) {
		return new EncoderDrive(-inchesToMove);
	}

	protected void initialize() {
		Robot.driveBase.ConfigEncoder();
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
		if (RobotMap.backLeft.getSelectedSensorPosition(0) > countsToMove - DEAD_ZONE
				&& RobotMap.backLeft.getSelectedSensorPosition(0) < countsToMove + DEAD_ZONE) {
			System.out.println("Done");
			return true;
		}
		return false;
	}

	protected void end() {
		Robot.driveBase.resetMotors();
	}

	protected void interrupted() {
		end();
	}
}
