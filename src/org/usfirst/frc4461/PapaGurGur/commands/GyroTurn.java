package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Turns the robot based on gyro readings.
 */
public class GyroTurn extends Command {

	private double degreesToTurn;
	private boolean isDone = false;
	private static final double TURN_SPEED = 0.2;
	private static final double DEAD_ZONE = 3;

	private GyroTurn(double degreesToTurn) {
		requires(Robot.gyro);
		this.degreesToTurn = degreesToTurn;
	}

	/**
	 * Turns the robot to the left by the specified degrees
	 * 
	 * @param degreesToTurn
	 *            Number of degrees to turn by
	 */
	public static GyroTurn turnLeft(double degreesToTurn) {
		return new GyroTurn(-degreesToTurn);
	}

	/**
	 * Turns the robot to the right by the specified degrees
	 * 
	 * @param degreesToTurn
	 *            Number of degrees to turn by
	 */
	public static GyroTurn turnRight(double degreesToTurn) {
		return new GyroTurn(degreesToTurn);
	}

	@Override
	protected void initialize() {
		Robot.gyro.resetGyro();
		System.out.println("Yes its working");
		Robot.driveBase.setDrivingRamp();
	}

	@Override
	protected void execute() {
		double facing = Robot.gyro.getAngle();

		if (Math.abs(facing) > (Math.abs(degreesToTurn) - DEAD_ZONE)
				&& Math.abs(facing) < (Math.abs(degreesToTurn) + DEAD_ZONE)) {
			Robot.driveBase.stopMotors();
			isDone = true;
		} else if (facing < degreesToTurn) {
			Robot.driveBase.turnRight(TURN_SPEED);
			System.out.println("Facing " + facing);
			System.out.println("we are going to the RIGHT");
		} else if (facing > degreesToTurn) {
			Robot.driveBase.turnLeft(TURN_SPEED);
			System.out.println("Facing " + facing);
			System.out.println("we are going to the left");
		}
	}

	@Override
	protected boolean isFinished() {
		return isDone;
	}

	@Override
	protected void end() {
		Robot.driveBase.stopMotors();
		Robot.driveBase.turnOffDrivingRamp();
	}

	@Override
	protected void interrupted() {
		end();
	}
}
