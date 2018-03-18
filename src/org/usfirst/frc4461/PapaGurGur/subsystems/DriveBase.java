package org.usfirst.frc4461.PapaGurGur.subsystems;

import org.usfirst.frc4461.PapaGurGur.RobotMap;
import org.usfirst.frc4461.PapaGurGur.commands.Driving;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveBase extends Subsystem {
    DifferentialDrive drive;

    public DriveBase() {
    }

    @Override
    public void initDefaultCommand() {
	setDefaultCommand(new Driving());
    }

    /**
     * Stops all drivebase motors This is useful for encapsulation and you don't
     * have to set Every motor to 0 in commands
     */
    public void stopMotors() {
	RobotMap.frontLeft.set(0);
	RobotMap.backLeft.set(0);
	RobotMap.frontRight.set(0);
	RobotMap.backRight.set(0);
    }

    /**
     * Turns right The speeds are set the same because 2 of the motors are
     * backwards
     * 
     * @param speed
     *            Percent speed to set the motors.
     */
    public void turnRight(double speed) {
	RobotMap.frontLeft.set(speed);
	RobotMap.backLeft.set(speed);
	RobotMap.frontRight.set(speed);
	RobotMap.backRight.set(speed);
    }

    /**
     * Turns left Speeds are set the same because 2 motors are backwards
     * 
     * @param speed
     *            Percent speed to set the motors.
     */
    public void turnLeft(double speed) {
	RobotMap.frontLeft.set(-speed);
	RobotMap.backLeft.set(-speed);
	RobotMap.frontRight.set(-speed);
	RobotMap.backRight.set(-speed);
    }

    /**
     * This is the configuration to make the encoders work
     */
    public void configEncoder() {
	RobotMap.frontLeft.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);
	RobotMap.frontLeft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
	RobotMap.frontLeft.setSelectedSensorPosition(0, 0, 10);
	RobotMap.frontLeft.setSensorPhase(true);
	RobotMap.frontLeft.setSafetyEnabled(true);

	RobotMap.frontRight.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);
	RobotMap.frontRight.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
	RobotMap.frontRight.setSelectedSensorPosition(0, 0, 10);
	RobotMap.frontRight.setSensorPhase(true);
	RobotMap.frontRight.setSafetyEnabled(true);

	RobotMap.backLeft.setSafetyEnabled(true);
	RobotMap.backRight.setSafetyEnabled(true);

	System.out.println("encoder initialize");
    }

    /**
     * After autonomous routines, set the configuration back to normal for
     * driving
     */
    public void resetMotors() {
	RobotMap.frontLeft.setSafetyEnabled(false);
	RobotMap.backLeft.setSafetyEnabled(false);
	RobotMap.frontRight.setSafetyEnabled(false);
	RobotMap.backLeft.setSafetyEnabled(false);

	RobotMap.frontRight.setInverted(false);
	RobotMap.backRight.setInverted(false);
	RobotMap.frontLeft.setInverted(false);
	RobotMap.backLeft.setInverted(false);

	RobotMap.frontRight.setSelectedSensorPosition(0, 0, 10);
	RobotMap.frontLeft.setSelectedSensorPosition(0, 0, 10);

    }

    /**
     * The command takes in the joystick axis value and then sets the motor
     * speed
     * 
     * @param lSpeed
     * @param rSpeed
     */
    public void drive(double lSpeed, double rSpeed) {
	RobotMap.frontLeft.set(ControlMode.PercentOutput, -lSpeed);
	RobotMap.backLeft.set(ControlMode.PercentOutput, -lSpeed);
	RobotMap.frontRight.set(ControlMode.PercentOutput, rSpeed);
	RobotMap.backRight.set(ControlMode.PercentOutput, rSpeed);
    }

    /**
     * Use encoder ticks to move the robot autonomously. Set inverted because of
     * the way the motors are setup
     * 
     * @param countsToMove
     */
    public void rightEncoder(double countsToMove) {
	RobotMap.frontRight.set(ControlMode.Position, countsToMove);
	RobotMap.backRight.set(ControlMode.Follower, 3);
    }

    public void leftEncoder(double countsToMove) {
	RobotMap.frontLeft.set(ControlMode.Position, -countsToMove);
	RobotMap.backLeft.set(ControlMode.Follower, RobotMap.frontLeft.getDeviceID());
    }

    public void EncoderMove(double countsToMove) {
	RobotMap.frontLeft.set(ControlMode.Position, -countsToMove);
	RobotMap.backLeft.set(ControlMode.Follower, RobotMap.frontLeft.getDeviceID());
	RobotMap.frontRight.set(ControlMode.Position, RobotMap.frontLeft.getDeviceID());
	RobotMap.backRight.set(ControlMode.Position, RobotMap.frontLeft.getDeviceID());
    }
}