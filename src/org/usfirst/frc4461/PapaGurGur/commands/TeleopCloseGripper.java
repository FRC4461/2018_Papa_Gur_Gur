package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TeleopCloseGripper extends Command {

    public TeleopCloseGripper() {
        requires(Robot.gripPneumatics);
    }

    protected void initialize() {
    }

    protected void execute() {
        Robot.gripPneumatics.closeGripper();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
