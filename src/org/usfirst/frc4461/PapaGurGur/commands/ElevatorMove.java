package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.OI;
import org.usfirst.frc4461.PapaGurGur.Robot;
import org.usfirst.frc4461.PapaGurGur.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorMove extends Command {

	
	
    public ElevatorMove() {
    }

    protected void initialize() {
    }

    protected void execute() {
    	double leftTriggerAxis = OI.getLeftXboxTriggerAxis();
    	double rightTriggerAxis = OI.getRightXboxTriggerAxis();
    	double differenceOfAxis = rightTriggerAxis - leftTriggerAxis;
    	if(differenceOfAxis > 0.1){
    		Robot.elevator.setElevatorUpSpeed(differenceOfAxis);
    	} else if(differenceOfAxis < 0.1 ){
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
    	Robot.elevator.stopMotor();
    }
}
