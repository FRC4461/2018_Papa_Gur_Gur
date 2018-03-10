package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;
import org.usfirst.frc4461.PapaGurGur.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *	
 */
public class AutonomousElevator extends Command {
	private static final double COUNTS_PER_REVOLUTION = 610;
	double countsToMove;

	double elevatorEncoder;
	double elevateSpeed = 0.2;
	double deadZone = 1;
	boolean done = false;

	public AutonomousElevator(double inchesToMove) {
		countsToMove = inchesToMove;
		requires(Robot.LMSystem);
	}

	protected void initialize() {
		Robot.LMSystem.ConfigElevatorEncoder();
	}

	protected void execute() {

		elevatorEncoder = RobotMap.elevatorMotor.getSelectedSensorPosition(0);
		RobotMap.elevatorMotor.set(elevateSpeed);
		if (elevatorEncoder >= countsToMove) {
			Robot.LMSystem.StopElevator();
			done = true;
		}
	}

	protected boolean isFinished() {
		return done;
	}

	protected void end() {
		Robot.LMSystem.StopElevator();
	}

	protected void interrupted() {
		end();
	}
}
