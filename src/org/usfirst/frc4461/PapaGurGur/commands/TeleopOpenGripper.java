package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TeleopOpenGripper extends Command {

	public TeleopOpenGripper() {
		requires(Robot.gripPneumatics);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.gripPneumatics.openGripper();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
