package org.usfirst.frc4461.PapaGurGur.subsystems;

import org.usfirst.frc4461.PapaGurGur.RobotMap;
import org.usfirst.frc4461.PapaGurGur.commands.GripperPneumatics;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gripper extends Subsystem {
    private static final double MOTOR_SPEED = 0.3;

    public Gripper() {
    }

    @Override
    protected void initDefaultCommand() {
	setDefaultCommand(new GripperPneumatics());
    }

    public void runIntake() {
	RobotMap.gripMotor1.set(-MOTOR_SPEED);
	RobotMap.gripMotor2.set(MOTOR_SPEED);
    }

    public void runOuttake() {
	RobotMap.gripMotor1.set(MOTOR_SPEED);
	RobotMap.gripMotor2.set(-MOTOR_SPEED);
    }

    public void stopMotors() {
	RobotMap.gripMotor1.set(0);
	RobotMap.gripMotor2.set(0);
    }

    public void configEncoders() {
	RobotMap.gripMotor1.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);
	RobotMap.gripMotor1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
	RobotMap.gripMotor1.setSelectedSensorPosition(0, 0, 10);
	RobotMap.gripMotor1.setSensorPhase(true);
	RobotMap.gripMotor1.setSafetyEnabled(false);
    }
}
