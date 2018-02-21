package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.OI;
import org.usfirst.frc4461.PapaGurGur.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorMove extends Command {

	
	private static double DEAD_ZONE = 0.1;
	
    public ElevatorMove() {
    	requires(Robot.elevator);
    }

    protected void initialize() {
    }

    protected void execute() {
    	double leftTriggerAxis = OI.getLeftXboxTriggerAxis();
    	double rightTriggerAxis = OI.getRightXboxTriggerAxis();
    	double differenceOfAxis = rightTriggerAxis - leftTriggerAxis;
    	if(differenceOfAxis > DEAD_ZONE){
    		Robot.elevator.setElevatorUpSpeed(differenceOfAxis);
    	} else if(differenceOfAxis < DEAD_ZONE ){
    		Robot.elevator.setElevatorDownSpeed(-differenceOfAxis);
    	}
    }

    protected boolean isFinished() {
    	return Robot.elevator.isStalled();
    }

    protected void end() {
    	Robot.elevator.stopMotor();
    }

    protected void interrupted() {
    	end();
    }
}
