package org.usfirst.frc4461.PapaGurGur.subsystems;

import org.usfirst.frc4461.PapaGurGur.RobotMap;
import org.usfirst.frc4461.PapaGurGur.commands.AutonomousElevator;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {

	public Elevator() {
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new AutonomousElevator(0));
	}

	// TODO: we don't want to use speed here. we need to change this to an actual position.
	public void elevatorGoUp(double elevateSpeed) {
		RobotMap.elevatorMotor.set(ControlMode.Position, elevateSpeed);
	}

	public void elevatorGoDown(double elevateSpeed) {
		RobotMap.elevatorMotor.set(ControlMode.Position, -elevateSpeed);
	}

	public void stopElevator() {
		RobotMap.elevatorMotor.set(0);
	}

	public void configElevatorEncoder() {
		RobotMap.elevatorMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 1);
		RobotMap.elevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 1);
		RobotMap.elevatorMotor.setSelectedSensorPosition(0, 0, 1);
		RobotMap.elevatorMotor.setSensorPhase(true);
		RobotMap.elevatorMotor.setSafetyEnabled(false);
	}

	public void resetElevator() {
		RobotMap.elevatorMotor.setSafetyEnabled(true);
	}

}