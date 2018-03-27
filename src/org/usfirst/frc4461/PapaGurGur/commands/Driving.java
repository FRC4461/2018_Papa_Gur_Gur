package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.OI;
import org.usfirst.frc4461.PapaGurGur.Robot;
import org.usfirst.frc4461.PapaGurGur.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/***
 * Command for controlling the drivebase. Uses joystick y-axes for speed for a
 * "tank drive" configuration.
 */
public class Driving extends Command {

	private double elevatorHeightThreshold;
	private double slowMultiplier;

	public Driving() {
		requires(Robot.driveBase);
	}

	@Override
	protected void initialize() {
		elevatorHeightThreshold = Robot.elevator.getSetThreshold();
		slowMultiplier = Robot.driveBase.slowMultiplier();
		RobotMap.frontLeft.setSelectedSensorPosition(0, 0, 1);
		RobotMap.frontRight.setSelectedSensorPosition(0, 0, 1);
	}

	@Override
	protected void execute() {
		double elevatorHeight = Robot.elevator.getElevatorHeightInches();

		double lSpeed = OI.lJoyGetY();
		double rSpeed = OI.rJoyGetY();

		if (elevatorHeight > elevatorHeightThreshold) {
			lSpeed *= slowMultiplier;
			rSpeed *= slowMultiplier;
		}

		int leftEncoder = RobotMap.frontLeft.getSelectedSensorPosition(0);
		int rightEncoder = RobotMap.frontRight.getSelectedSensorPosition(0);

		System.out.println("Left: " + " " + leftEncoder + "Right: " + rightEncoder);
		Robot.driveBase.drive(lSpeed, rSpeed);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
}
