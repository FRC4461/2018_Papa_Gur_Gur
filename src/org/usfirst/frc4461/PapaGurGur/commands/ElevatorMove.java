package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorMove extends Command {

	Direction direction;
	
	public enum Direction{
		UP, DOWN
	};
	
    public ElevatorMove(Direction direction) {
    	this.direction = direction;
    }

    protected void initialize() {
    }

    protected void execute() {
    	if(direction == Direction.UP){
    		Robot.elevator.setElevatorPositionUp();
    	}
    	if(direction == Direction.DOWN){
    		Robot.elevator.setElevatorPositionDown();
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
