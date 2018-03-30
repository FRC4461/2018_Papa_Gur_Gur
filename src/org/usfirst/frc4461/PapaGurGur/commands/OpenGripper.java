package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.command.Command;

/***
 * Command for opening the gripper in autonomous.
 */
public class OpenGripper extends Command {

    private double timeOut;

    private boolean isDone = false;

    /***
     * Opens the gripper.
     * 
     * @param timeOut
     *            Seconds to end command
     */
    public OpenGripper(double timeOut) {
        requires(Robot.gripPneumatics);
        this.timeOut = timeOut;
        setTimeout(this.timeOut);
    }

    protected void initialize() {
        Robot.gripPneumatics.openGripper();
    }

    protected void execute() {
        isDone = true;
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
