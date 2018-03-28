package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;
import org.usfirst.frc4461.PapaGurGur.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command for driving the robot to an exact position through encoder counts.
 */
public class EncoderDrive extends Command {

	private static final int COUNTS_PER_REVOLUTION = 512;
	private static final double GEAR_REDUCTION = (45.0 / 19.0) * (50.0 / 14.0);
	private static final double COUNTS_PER_WHEEL_REVOLUTION = COUNTS_PER_REVOLUTION * GEAR_REDUCTION;
	private static final double WHEEL_CIRCUMFERENCE = 6 * Math.PI;
	private static final double COUNTS_PER_INCH = 190; // COUNTS_PER_WHEEL_REVOLUTION
														// WHEEL_CIRCUMFERENCE;

	private final static double RAMP_SPEED = 2;
	private final static double LEFT_SPEED = -0.5;
	private final static double RIGHT_SPEED = -0.55;

	private static final int DEFAULT_TIMEOUT = 3;

	private final int countsToMove;

	private boolean isDone = false;

	private static final double DRIVING_MULTIPLIER = 1.3;

	/**
	 * Drives forward based on inches.
	 *
	 * @param inchesToMove
	 *            The number of inches to move. Setting a negative value will
	 *            drive backwards.
	 */

	private EncoderDrive(double inchesToMove) {
		requires(Robot.driveBase);
		countsToMove = (int) (COUNTS_PER_INCH * inchesToMove);
	}

	public static EncoderDrive GoForward(double inchesToMove) {
		return new EncoderDrive(inchesToMove);
	}

	public static EncoderDrive GoBackward(double inchesToMove) {
		return new EncoderDrive(-inchesToMove);
	}

	@Override
	protected void initialize() {
		Robot.driveBase.configEncoder();
		// Robot.driveBase.setDrivingRamp();
		Robot.gyro.resetGyro();
	}

	@Override
	protected void execute() {
		int leftEncoder = RobotMap.frontLeft.getSelectedSensorPosition(0);
		int rightEncoder = RobotMap.frontRight.getSelectedSensorPosition(0);
		double gyroAngle = Robot.gyro.getAngle();

		System.out.println(
				"Left: " + " " + leftEncoder + "Right: " + rightEncoder + " " + "Counts To Move: " + countsToMove);

		// Gyro ANgle
		System.out.println(gyroAngle);
		if (gyroAngle > -1 && gyroAngle < 1) {
			Robot.driveBase.drive(LEFT_SPEED, RIGHT_SPEED);
		} else if (gyroAngle < -1) {
			System.out.println("Go left FASTER");
			Robot.driveBase.drive(LEFT_SPEED * DRIVING_MULTIPLIER, RIGHT_SPEED);
		} else if (gyroAngle > 1) {
			System.out.println("Go right FASTER");
			Robot.driveBase.drive(LEFT_SPEED, RIGHT_SPEED * DRIVING_MULTIPLIER);
		}
		if (leftEncoder >= countsToMove) {
			Robot.driveBase.stopMotors();
			isDone = true;
			System.out.println("STOP");
		}
		// && -rightEncoder >= countsToMove
	}

	@Override
	protected boolean isFinished() {
		return isDone;// || isTimedOut();
	}

	@Override
	protected void end() {
		Robot.driveBase.resetMotors();
		Robot.driveBase.stopMotors();
		Robot.driveBase.turnOffDrivingRamp();
	}

	@Override
	protected void interrupted() {
		end();
	}
}