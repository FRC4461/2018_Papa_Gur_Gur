package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OpenGripper extends Command {

    private double timeOut;

    public OpenGripper(double timeOut) {
	requires(Robot.gripPneumatics);
	this.timeOut = timeOut;
	setTimeout(this.timeOut);
    }

    protected void initialize() {
    }

    protected void execute() {
	Robot.gripPneumatics.openGripper();
    }

    protected boolean isFinished() {
	return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
