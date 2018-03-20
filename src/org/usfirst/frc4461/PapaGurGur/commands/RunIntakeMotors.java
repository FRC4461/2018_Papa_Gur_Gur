package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RunIntakeMotors extends Command {

    public RunIntakeMotors() {
	requires(Robot.gripMotors);
    }

    protected void initialize() {
    }

    protected void execute() {
	Robot.gripMotors.runIntake();
    }

    protected boolean isFinished() {
	return false;
    }

    protected void end() {
	Robot.gripMotors.stopMotors();
    }

    protected void interrupted() {
	end();
    }
}
