package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PrepareToGrabCube extends Command {

    public PrepareToGrabCube() {
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.gripper.RunIntakeMotors();
    	Robot.gripper.OpenGripper();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end(){
    	Robot.gripper.stopGripMotors();
    }

    protected void interrupted() {
    }
}
