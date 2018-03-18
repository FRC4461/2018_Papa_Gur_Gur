package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Sets the motors to run outwards to push out the cube. Will usually not run in
 * place of opening the gripper.
 */
public class RunOuttake extends Command {
    
    public RunOuttake() {
	requires(Robot.gripMotors);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
	Robot.gripMotors.runOuttake();
    }

    @Override
    protected boolean isFinished() {
	return false;
    }

    @Override
    protected void end() {
	Robot.gripMotors.stopMotors();
    }

    @Override
    protected void interrupted() {
	end();
    }
}
