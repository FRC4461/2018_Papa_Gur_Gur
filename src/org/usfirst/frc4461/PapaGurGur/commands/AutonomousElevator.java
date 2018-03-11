package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;
import org.usfirst.frc4461.PapaGurGur.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousElevator extends Command {
    private static final double COUNTS_PER_REVOLUTION = 610;
    private double countsToMove;

    private double elevateSpeed = 0.2;

    private boolean isDone = false;

    public AutonomousElevator(double inchesToMove) {
	countsToMove = inchesToMove;
	requires(Robot.elevator);
    }

    public enum ElevatorPositions {
	DOWN, SWITCH, SCALE_LOW, SCALE_MIDDLE, SCALE_HIGH
    }

    @Override
    protected void initialize() {
	Robot.elevator.configElevatorEncoder();
    }

    @Override
    protected void execute() {
	int elevatorEncoder = RobotMap.elevatorMotor.getSelectedSensorPosition(0);
	RobotMap.elevatorMotor.set(elevateSpeed);

	if (elevatorEncoder >= countsToMove) {
	    Robot.elevator.stopElevator();
	    isDone = true;
	}
    }

    @Override
    protected boolean isFinished() {
	return isDone;
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
