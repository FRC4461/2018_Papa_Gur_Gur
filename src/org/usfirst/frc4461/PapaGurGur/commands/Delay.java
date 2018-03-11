package org.usfirst.frc4461.PapaGurGur.commands;

import edu.wpi.first.wpilibj.command.Command;

public class Delay extends Command {
	private double timeToDelay;

	public Delay(double delayTime) {
		timeToDelay = delayTime;
	}

	protected void initialize() {
		setTimeout(timeToDelay);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
