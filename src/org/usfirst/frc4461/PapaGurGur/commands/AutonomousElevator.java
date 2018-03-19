package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousElevator extends Command {

    private double inchesToMove;

    public AutonomousElevator(double inchesToMove) {
	requires(Robot.elevator);
	this.inchesToMove = inchesToMove;
    }

    protected void initialize() {
	Robot.elevator.configElevatorEncoder();
	System.out.println("Elevator initialize");
    }

    protected void execute() {
	double elevatorHeight = Robot.elevator.getElevatorHeightInches();
	double elevateSpeed = Robot.elevator.getElevateSpeed();
	if (elevatorHeight < inchesToMove) {
	    Robot.elevator.elevatorGoUp(elevateSpeed);
	} else if (elevatorHeight >= inchesToMove) {
	    Robot.elevator.stopElevator();
	}
    }

    protected boolean isFinished() {
	return false;
    }

    protected void end() {
	Robot.elevator.stopElevator();
    }

    protected void interrupted() {
	end();
    }
}
