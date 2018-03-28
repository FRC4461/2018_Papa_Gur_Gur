package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;
import org.usfirst.frc4461.PapaGurGur.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/***
 * Command for using the elevator in autonomous. Position is controlled by
 * encoders.
 */
public class AutonomousElevator extends Command {

	private final double inchesToMove;

	private AutonomousElevator(double inchesToMove) {
		requires(Robot.elevator);
		this.inchesToMove = inchesToMove;
	}

	/***
	 * Raises the elevator by inches.
	 * 
	 * @param inchesToMove
	 */
	public static AutonomousElevator GoUp(double inchesToMove) {
		return new AutonomousElevator(-inchesToMove);
	}

	/***
	 * Lowers the elevator by inches.
	 * 
	 * @param inchesToMove
	 */
	public static AutonomousElevator GoDown(double inchesToMove) {
		return new AutonomousElevator(inchesToMove);
	}

	protected void initialize() {
		Robot.elevator.configElevatorEncoder();
		Robot.elevator.setElevatorRamp();
		System.out.println("Elevator initialize");
	}

	/*
	 * Robot uses setPosition to go to a specific count Works great with current
	 * PID settings also we want this to be always runnning in autonomous
	 * because we want the elevator to always be up
	 */
	protected void execute() {
		System.out.println("Elevator height: " + RobotMap.elevatorMotor.getSelectedSensorPosition(0) / (328));
		System.out.println("Inches to move: " + inchesToMove);

		Robot.elevator.elevatorPosition(inchesToMove);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.elevator.turnOffElevatorRamp();
	}

	protected void interrupted() {
		end();
	}
}
