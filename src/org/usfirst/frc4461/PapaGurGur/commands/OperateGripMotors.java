package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.OI;
import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.command.Command;

/***
 * Command for operating the gripper motors using the Xbox controller. Each side
 * can be run independently.
 */
public class OperateGripMotors extends Command {

    public OperateGripMotors() {
        requires(Robot.gripMotors);
    }

    protected void initialize() {
    }

    protected void execute() {
        boolean rightBumper = OI.getRightBumper();
        boolean leftBumper = OI.getLeftBumper();

        if (rightBumper) {
            Robot.gripMotors.runIntake();
        } else if (leftBumper) {
            Robot.gripMotors.runOuttake();
        } else if (Math.abs(OI.rightXboxStick()) > 0.1 || Math.abs(OI.leftXboxStick()) > 0.1) {
            Robot.gripMotors.runRightSide(OI.rightXboxStick());
            Robot.gripMotors.runLeftSide(OI.leftXboxStick());
        } else {
            Robot.gripMotors.stopMotors();
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
