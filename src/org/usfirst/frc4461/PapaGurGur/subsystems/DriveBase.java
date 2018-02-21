package org.usfirst.frc4461.PapaGurGur.subsystems;

import org.usfirst.frc4461.PapaGurGur.RobotMap;
import org.usfirst.frc4461.PapaGurGur.commands.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveBase extends Subsystem {
	DifferentialDrive drive;

	public DriveBase() {

	}

	public void initDefaultCommand() {
		setDefaultCommand(new Driving());
	}

	public void stopMotors() {
		RobotMap.frontLeft.set(0);
		RobotMap.backLeft.set(0);
		RobotMap.frontRight.set(0);
		RobotMap.backRight.set(0);
	}

	public void turnRight(double SPEED) {
		RobotMap.frontLeft.set(SPEED);
		RobotMap.backLeft.set(SPEED);
		RobotMap.frontRight.set(SPEED);
		RobotMap.backRight.set(SPEED);
	}

	public void turnLeft(double SPEED) {
		RobotMap.frontLeft.set(-SPEED);
		RobotMap.backLeft.set(-SPEED);
		RobotMap.frontRight.set(-SPEED);
		RobotMap.backRight.set(-SPEED);
	}

	public void ConfigEncoder() {
		RobotMap.backLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 1);
		RobotMap.backLeft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 1);
		RobotMap.backLeft.setSelectedSensorPosition(0, 0, 1);
		RobotMap.backLeft.setSensorPhase(true);
		RobotMap.backLeft.setSafetyEnabled(false);
		System.out.println("encoder initialize");
	}

	public void resetMotors() {
		RobotMap.backLeft.setSafetyEnabled(true);
		RobotMap.backRight.setInverted(false);
		RobotMap.frontRight.setInverted(false);
		RobotMap.backLeft.setInverted(false);
		RobotMap.frontLeft.setInverted(false);
		System.out.println(RobotMap.backLeft.getSelectedSensorPosition(0));
	}

	public void drive(double lSpeed, double rSpeed) {
		RobotMap.frontLeft.set(ControlMode.PercentOutput, -lSpeed);
		RobotMap.backLeft.set(ControlMode.PercentOutput, -lSpeed);
		RobotMap.frontRight.set(ControlMode.PercentOutput, rSpeed);
		RobotMap.backRight.set(ControlMode.PercentOutput, rSpeed);
	}

	public void moveEncoder(double countsToMove) {
		RobotMap.backRight.setInverted(false);
		RobotMap.frontRight.setInverted(false);
		RobotMap.backLeft.setInverted(true);
		RobotMap.frontLeft.setInverted(true);
		
		RobotMap.backLeft.set(ControlMode.Position, countsToMove);
		RobotMap.frontLeft.set(ControlMode.Follower, RobotMap.backLeft.getDeviceID());
		RobotMap.frontRight.set(ControlMode.Follower, RobotMap.backLeft.getDeviceID());
		RobotMap.backRight.set(ControlMode.Follower, RobotMap.backLeft.getDeviceID());
	}
}