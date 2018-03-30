package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.command.Command;

/***
 * Command for closing the gripper in autonomous.
 */
public class CloseGripper extends Command {

    /***
     * Closes the gripper.
     * 
     * @param timeOut
     *            Seconds to end command
     */
    public CloseGripper() {
        requires(Robot.gripPneumatics);
    }

    protected void initialize() {
        Robot.gripPneumatics.closeGripper();
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
