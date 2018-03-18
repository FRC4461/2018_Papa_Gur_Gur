package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Sets the motors to run inwards to intake the cube
 */
public class RunIntake extends Command {
    
    public RunIntake() {
	requires(Robot.gripMotors);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
	Robot.gripMotors.runIntake();
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
