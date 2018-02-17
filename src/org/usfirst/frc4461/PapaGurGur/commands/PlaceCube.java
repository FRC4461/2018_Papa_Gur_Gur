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
    }

    protected void execute() {
    	Robot.gripper.RunOuttakeMotors();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.gripper.stopMotors();
    }

    protected void interrupted() {
    	Robot.gripper.stopMotors();
    }
}
