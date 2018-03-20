package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousElevator extends Command {

    private double inchesToMove;

    private AutonomousElevator(double inchesToMove) {
	requires(Robot.elevator);
	this.inchesToMove = inchesToMove;
    }

    public static AutonomousElevator GoUp(double inchesToMove) {
	return new AutonomousElevator(inchesToMove);
    }

    public static AutonomousElevator GoDown(double inchesToMove) {
	return new AutonomousElevator(-inchesToMove);
    }

    protected void initialize() {
	Robot.elevator.configElevatorEncoder();
	System.out.println("Elevator initialize");
    }

    protected void execute() {
	double autoDeadZone = Robot.elevator.setAutoDeadZone();
	double elevatorHeight = Robot.elevator.getElevatorHeightInches();
	double elevateSpeed = Robot.elevator.getElevateSpeed();

	if (elevatorHeight + autoDeadZone < inchesToMove) {
	    Robot.elevator.elevatorGoUp(elevateSpeed);
	} else if (elevatorHeight - autoDeadZone > inchesToMove) {
	    Robot.elevator.elevatorGoDown(elevateSpeed);
	} else {
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
