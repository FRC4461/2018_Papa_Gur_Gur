package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;
import org.usfirst.frc4461.PapaGurGur.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class EncoderDrive extends Command {
	private static final int COUNTS_PER_REVOLUTION = 512;
	private static final double GEAR_REDUCTION = (45.0 / 19.0) * (50.0 / 14.0);
	private static final double COUNTS_PER_WHEEL_REVOLUTION = COUNTS_PER_REVOLUTION * GEAR_REDUCTION;
	private static final double WHEEL_CIRCUMFERENCE = 6 * Math.PI;
	private static final double COUNTS_PER_INCH = COUNTS_PER_WHEEL_REVOLUTION / WHEEL_CIRCUMFERENCE;
	
	private static final double LEFT_SPEED = 0.4;
	private static final double RIGHT_SPEED = 0.3;
	private static final double OVERSHOOT_MULTIPLIER = 6000;

	int leftEncoder;
	int rightEncoder;
	
	int countsToMove;
	
	boolean done = false;

	public EncoderDrive(double inchesToMove) {

		requires(Robot.driveBase);
		countsToMove = (int)(COUNTS_PER_INCH * inchesToMove);
	}

	protected void initialize() {
		done = false;
		Robot.driveBase.ConfigEncoder();
	}

	protected void execute() {
		leftEncoder = RobotMap.frontLeft.getSelectedSensorPosition(0);
		rightEncoder = RobotMap.frontRight.getSelectedSensorPosition(0);

		Robot.driveBase.drive(-LEFT_SPEED, -RIGHT_SPEED);
		
		if(leftEncoder > countsToMove - LEFT_SPEED * OVERSHOOT_MULTIPLIER){
			RobotMap.backLeft.set(0);
			RobotMap.frontLeft.set(0);
		}
		
		if (-rightEncoder > countsToMove - RIGHT_SPEED * OVERSHOOT_MULTIPLIER) {
			RobotMap.backRight.set(0);
			RobotMap.frontRight.set(0);
		} 
		
		if(leftEncoder > countsToMove - 500 && -rightEncoder > countsToMove - 500){
			Robot.driveBase.stopMotors();
			done = true;

		}
		else {
			System.out.println("right sensor: " + rightEncoder);
			System.out.println("left sensor : " + leftEncoder);
		}
	}

	protected boolean isFinished() {
		return done;
	}

	protected void end() {
		Robot.driveBase.resetMotors();
		Robot.driveBase.stopMotors();
	}

	protected void interrupted() {
		end();
	}
}
