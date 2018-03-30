package org.usfirst.frc4461.PapaGurGur.commands;

import edu.wpi.first.wpilibj.command.Command;

/***
 * Command for setting a delay during autonomous.
 */
public class Delay extends Command {

    private double timeToDelay;

    /***
     * Delays a command in autonomous.
     * 
     * @param delayTime
     *            Seconds to delay by
     */
    public Delay(double delayTime) {
        timeToDelay = delayTime;
    }

    @Override
    protected void initialize() {
        setTimeout(timeToDelay);
    }

    @Override
    protected void execute() {
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }
}
