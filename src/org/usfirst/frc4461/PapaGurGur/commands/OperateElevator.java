package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.OI;
import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OperateElevator extends Command {

    private double deadZone;
    private double maxDownSpeed;

    public OperateElevator() {
	requires(Robot.elevator);
    }

    @Override
    protected void initialize() {
	deadZone = Robot.elevator.setDeadZone();
	maxDownSpeed = Robot.elevator.setDownSpeed();
    }

    @Override
    protected void execute() {
	double rightTriggerAxis = OI.rightXboxTrigger();
	double leftTriggerAxis = OI.leftXboxTrigger();
	double differenceOfAxis = rightTriggerAxis - leftTriggerAxis;

	if (differenceOfAxis > deadZone) {
	    Robot.elevator.elevatorGoUp(differenceOfAxis);
	} else if (differenceOfAxis < deadZone) {
	    Robot.elevator.elevatorGoDown(-differenceOfAxis * maxDownSpeed);
	} else {
	    Robot.elevator.stopElevator();
	}
    }

    @Override
    protected boolean isFinished() {
	return false;
    }

    @Override
    protected void end() {
	Robot.elevator.stopElevator();
    }

    @Override
    protected void interrupted() {
	end();
    }
}
