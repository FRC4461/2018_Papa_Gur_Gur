package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CloseGripper extends Command {

    private double timeOut;

    public CloseGripper(double timeOut) {
	requires(Robot.gripPneumatics);
	this.timeOut = timeOut;
	setTimeout(this.timeOut);
    }

    protected void initialize() {
    }

    protected void execute() {
	Robot.gripPneumatics.closeGripper();
    }

    protected boolean isFinished() {
	return isTimedOut();
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
