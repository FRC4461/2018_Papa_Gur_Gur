package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;
import org.usfirst.frc4461.PapaGurGur.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Runs the wheels on the gripper for intake or outtake.
 */
public class GripperMotors extends Command {

    GripperMotorState motorState;
    boolean isDone = false;

    private static final int CUBE_LENGTH = 15;
    private static final int COUNTS_PER_REVOLUTION = 610;
    private static final double WHEEL_CIRCUMFERENCE = 6.0 * Math.PI;
    private static final double GEAR_REDUCTION = (1.0 / 1.0);
    private static final double CUBE_LENGTH_COUNTS = CUBE_LENGTH * COUNTS_PER_REVOLUTION * GEAR_REDUCTION
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
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
	switch (motorState) {
	case INTAKE:
	    Robot.gripper.runIntake();
	    break;
	case OUTTAKE:
	    Robot.gripper.runOuttake();
	    break;
	case STOP:
	    Robot.gripper.stopMotors();
	    isDone = true;
	}

	// TODO: Actually figure out what value will tell us the cube made
	// it in
	// securely
	if (RobotMap.gripMotor1.getOutputCurrent() > 10) {
	    isDone = true;
	}
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
	return isDone;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
