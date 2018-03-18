package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OpenGripper extends Command {

    public OpenGripper() {
	requires(Robot.gripper);
    }

    protected void initialize() {
    }

    protected void execute() {
	Robot.gripper.openGripper();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
