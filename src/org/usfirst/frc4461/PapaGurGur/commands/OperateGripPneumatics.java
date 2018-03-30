package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.OI;
import org.usfirst.frc4461.PapaGurGur.Robot;
import org.usfirst.frc4461.PapaGurGur.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/***
 * Command for opening and closing the gripper through the pneumatics system
 * using the Xbox controller buttons.
 */
public class OperateGripPneumatics extends Command {

    public OperateGripPneumatics() {
        requires(Robot.gripPneumatics);
    }

    protected void initialize() {
    }

    protected void execute() {
        boolean getAButton = OI.isAButtonPressed();
        boolean getBButton = OI.isBButtonPressed();

        if (getAButton) {
            Robot.gripPneumatics.closeGripper();
        } else if (getBButton) {
            Robot.gripPneumatics.openGripper();
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
