package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.OI;
import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *	
 */
public class Elevator extends Command {

	public Elevator() {
		requires(Robot.LMSystem);
	}

	protected void initialize() {
	}

	protected void execute() {
		double elevateSpeed = 0.5;

		if (OI.isAButtonPressed())
			Robot.LMSystem.ElevatorGoUp(elevateSpeed);
		if (OI.isBButtonPressedd())
			Robot.LMSystem.ElevatorGoDown(elevateSpeed);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.LMSystem.StopElevator();
	}

	protected void interrupted() {
		end();
	}
}
