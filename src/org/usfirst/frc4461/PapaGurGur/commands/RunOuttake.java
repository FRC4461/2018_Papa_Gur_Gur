package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Sets the motors to run outwards to push out the cube. Will usually not run in
 * place of opening the gripper.
 */
public class RunOuttake extends Command {
    public RunOuttake() {
	requires(Robot.gripper);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
	Robot.gripper.runOuttake();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
	return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
	Robot.gripper.stopMotors();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
	end();
    }
}
