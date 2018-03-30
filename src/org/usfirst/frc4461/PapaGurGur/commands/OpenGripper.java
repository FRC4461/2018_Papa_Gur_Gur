package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.command.Command;

/***
 * Command for opening the gripper in autonomous.
 */
public class OpenGripper extends Command {

    private double timeOut;

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
