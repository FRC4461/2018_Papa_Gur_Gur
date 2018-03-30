package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.command.Command;

/***
 * Command for opening the gripper in autonomous.
 */
public class OpenGripper extends Command {

    /***
     * Opens the gripper.
     * 
     * @param timeOut
     *            Seconds to end command
     */
    public OpenGripper() {
        requires(Robot.gripPneumatics);
    }

    protected void initialize() {
        Robot.gripPneumatics.openGripper();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
