package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.OI;
import org.usfirst.frc4461.PapaGurGur.Robot;
import org.usfirst.frc4461.PapaGurGur.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Driving extends Command {

	private double elevatorHeight;
	private double elevatorHeightThreshold;
	private double slowMultiplier;

	public Driving() {
		requires(Robot.driveBase);
	}

	@Override
	protected void initialize() {
		elevatorHeightThreshold = Robot.elevator.getThreshold();
		slowMultiplier = Robot.driveBase.slowMultiplier();
	}

	@Override
	protected void execute() {
		elevatorHeight = Robot.elevator.getElevatorHeightInches();

		double lSpeed = OI.lJoyGetY();
		double rSpeed = OI.rJoyGetY();

		if (elevatorHeight > elevatorHeightThreshold) {
			lSpeed *= slowMultiplier;
			rSpeed *= slowMultiplier;
		}
		
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
