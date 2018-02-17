package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PlaceCube extends Command {

    public PlaceCube() {
    }

    protected void initialize() {
    	setTimeout(1);
    }

    protected void execute() {
    	Robot.gripper.RunOuttakeMotors();
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    	Robot.gripper.stopMotors();
    }

    protected void interrupted() {
    	Robot.gripper.stopMotors();
    }
}
