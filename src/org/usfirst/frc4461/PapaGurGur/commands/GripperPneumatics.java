package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Opens and closes the gripper.
 */
public class GripperPneumatics extends Command {

	private boolean isOpen = false;

	/**
	 * Changes the state of the gripper
	 */
	public GripperPneumatics() {
		requires(Robot.gripper);
		isOpen = !isOpen;
	}

	/**
	 * Specify directly what state to put the gripper in.
	 * 
	 * @param open Set True to open the gripper. Set False to close the gripper.
	 */
	public GripperPneumatics(boolean open) {
		requires(Robot.gripper);
		isOpen = open;
	}

	// Called just before this Command runs the first time
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (isOpen) {
			// pneumatics set to be open
		} else {
			// pneumatics set to be closed
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

	/*
	 * Returns whether the gripper is opened (true) or closed (false)
	 */
	public boolean getGripperState() {
		return isOpen;
	}
}
