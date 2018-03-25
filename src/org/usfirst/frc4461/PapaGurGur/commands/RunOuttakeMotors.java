package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RunOuttakeMotors extends Command {

	private double timeOut;

	public RunOuttakeMotors(double timeOut) {
		requires(Robot.gripMotors);
		this.timeOut = timeOut;
		setTimeout(this.timeOut);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.gripMotors.runOuttake();
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
		Robot.gripMotors.stopMotors();
	}

	protected void interrupted() {
		end();
	}
}
