package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.OI;
import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OperateGripper extends Command {

	public OperateGripper() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.gripper);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		OI.lButton1.cancelWhenActive(outtake());
		OI.lButton1.toggleWhenPressed(intake());

		OI.rButton1.cancelWhenActive(intake());
		OI.lButton1.toggleWhenActive(outtake());

		if (!OI.lButton1.get() && !OI.rButton1.get()) {
			Robot.gripper.stopMotors();
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}

	private static Command intake() {
		Robot.gripper.runIntake();
		return null;
	}

	private static Command outtake() {
		Robot.gripper.runOuttake();
		return null;
	}
}
