package org.usfirst.frc4461.PapaGurGur.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc4461.PapaGurGur.OI;
import org.usfirst.frc4461.PapaGurGur.Robot;

/**
 *
 */
public class Driving extends Command {

	public Driving() {
		requires(Robot.driveBase);
	}

	protected void initialize() {
	}

	protected void execute() {
		double lSpeed = OI.lJoyGetY();
		double rSpeed = OI.rJoyGetY();
		Robot.driveBase.drive(lSpeed, rSpeed);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
