package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;
import org.usfirst.frc4461.PapaGurGur.RobotMap;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Runs the wheels on the gripper for intake or outtake.
 */
public class GripperMotors extends Command {

	GripperMotorState motorState;
	boolean isDone = false;

	private static final int CUBE_LENGTH = 15;
	private static final int COUNTS_PER_REVOLUTION = 610;
	private static final float WHEEL_CIRCUMFERENCE = (float) (6.0f * Math.PI);
	private static final float GEAR_REDUCTION = (float) (1 / 1);
	private static final float CUBE_LENGTH_COUNTS = CUBE_LENGTH * COUNTS_PER_REVOLUTION * GEAR_REDUCTION
			/ WHEEL_CIRCUMFERENCE;

	/**
	 * Sets the motors to INTAKE, OUTTAKE, or STOP.
	 * 
	 * @param motorState
	 *            Use GripperMotorState.INTAKE, GripperMotorState.OUTTAKE, or
	 *            GripperMotorState.STOP
	 */
	public GripperMotors(GripperMotorState motorState) {
		requires(Robot.gripper);

		this.motorState = motorState;
	}

	public enum GripperMotorState {
		INTAKE, OUTTAKE, STOP
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		RobotMap.gripMotor1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 1);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (motorState == GripperMotorState.INTAKE) {
			Robot.gripper.runIntake();

			// TODO: Actually figure out what value will tell us the cube made
			// it in
			// securely
			if (RobotMap.gripMotor1.getOutputCurrent() > 10) {
				isDone = true;
			}
		} else if (motorState == GripperMotorState.OUTTAKE) {
			Robot.gripper.runOuttake();

			if (RobotMap.gripMotor1.getSelectedSensorPosition(0) < -CUBE_LENGTH_COUNTS) {
				isDone = true;
			}
		} else {
			Robot.gripper.stopMotors();
			isDone = true;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isDone;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
