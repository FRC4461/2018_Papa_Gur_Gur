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

	public void ElevatorGoUp(double elevateSpeed) {
		RobotMap.elevatorMotor.set(ControlMode.Position, elevateSpeed);
	}

	public void ElevatorGoDown(double elevateSpeed) {
		RobotMap.elevatorMotor.set(ControlMode.Position, -elevateSpeed);
	}

	public void StopElevator() {
		RobotMap.elevatorMotor.set(0);
	}

	public void ConfigElevatorEncoder() {
		RobotMap.elevatorMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 1);
		RobotMap.elevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 1);
		RobotMap.elevatorMotor.setSelectedSensorPosition(0, 0, 1);
		RobotMap.elevatorMotor.setSensorPhase(true);
		RobotMap.elevatorMotor.setSafetyEnabled(false);
	}

	public void ResetElevator() {
		RobotMap.elevatorMotor.setSafetyEnabled(true);
	}

}