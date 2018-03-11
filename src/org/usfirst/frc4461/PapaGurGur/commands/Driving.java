package org.usfirst.frc4461.PapaGurGur.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc4461.PapaGurGur.OI;
import org.usfirst.frc4461.PapaGurGur.Robot;
import org.usfirst.frc4461.PapaGurGur.RobotMap;

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
		
		System.out.println("Left: " + RobotMap.frontLeft.getSelectedSensorPosition(0));
		System.out.println("Right: " + RobotMap.frontRight.getSelectedSensorPosition(0));
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
