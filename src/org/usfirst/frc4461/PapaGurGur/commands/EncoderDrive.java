package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;
import org.usfirst.frc4461.PapaGurGur.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class EncoderDrive extends Command {
	double countsToMove;
	double leftEncoder;
	double rightEncoder;
	boolean done = false;
		
	public EncoderDrive(double inchesToMove) {
		requires(Robot.driveBase);
		countsToMove = inchesToMove;
	}

	protected void initialize() {
		Robot.driveBase.ConfigEncoder();
	}
	protected void execute() {
		leftEncoder = RobotMap.frontLeft.getSelectedSensorPosition(0);
		rightEncoder = RobotMap.frontRight.getSelectedSensorPosition(0);
		System.out.println("left sensor: " + leftEncoder);
		System.out.println("right sensor: " + rightEncoder);
		
		Robot.driveBase.drive(0.3, 0.3);
		
		if(leftEncoder > countsToMove && rightEncoder > countsToMove){
			Robot.driveBase.stopMotors();
			done = true;
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
