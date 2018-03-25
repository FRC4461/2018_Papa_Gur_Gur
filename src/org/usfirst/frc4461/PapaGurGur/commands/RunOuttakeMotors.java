package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.command.Command;

/***
 * Command to run motors for outtake in autonomous.
 */
public class RunOuttakeMotors extends Command {

	private double timeOut;

	/***
	 * Runs the motors to push out a cube.
	 * 
	 * @param timeOut Seconds to end command
	 */
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
