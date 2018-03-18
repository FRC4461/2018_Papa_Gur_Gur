package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.OI;
import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OperateElevator extends Command {

    private final double DEAD_ZONE = 0.1;
    private final double MAX_DOWNSPEED = 0.2;
    
    public OperateElevator() {
	requires(Robot.elevator);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
	double rightTriggerAxis = OI.rightXboxTrigger();
	double leftTriggerAxis = OI.leftXboxTrigger();

	double differenceOfAxis = rightTriggerAxis - leftTriggerAxis;
	
	if (differenceOfAxis > DEAD_ZONE) {
	    Robot.elevator.elevatorGoUp(differenceOfAxis);
	} else if (differenceOfAxis < DEAD_ZONE) {
	    Robot.elevator.elevatorGoDown(-differenceOfAxis * MAX_DOWNSPEED);
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
