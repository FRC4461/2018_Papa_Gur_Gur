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
	private double autoDeadZone;
	private double elevatorHeight;

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
		System.out.println("Elevator initialize");

		autoDeadZone = Robot.elevator.setAutoDeadZone();
	}

	// estoy confused. this doesn't even read counts when does it stop xd
	// i can imagine the elevator flying off
	protected void execute() {

		elevatorHeight = Robot.elevator.getElevatorHeightInches();
		System.out.println("Elevator height: " + RobotMap.elevatorMotor.getSelectedSensorPosition(0) / (328));
		System.out.println("Inches to move: " + inchesToMove);
		
		Robot.elevator.elevatorPosition(inchesToMove);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
		end();
	}
}
