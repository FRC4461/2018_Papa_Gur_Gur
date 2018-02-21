package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PlaceCube extends Command {

	private static double TIMEOUT = 1;
	
    public PlaceCube() {
    	requires(Robot.gripper);
    }

    protected void initialize() {
    	setTimeout(TIMEOUT);
    }

    protected void execute() {
    	Robot.gripper.RunOuttakeMotors();
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    	Robot.gripper.stopGripMotors();
    }

    protected void interrupted() {
    	end();
    }
}
