package org.usfirst.frc4461.PapaGurGur.subsystems;

import org.usfirst.frc4461.PapaGurGur.RobotMap;
import org.usfirst.frc4461.PapaGurGur.commands.OperateElevator;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {

	private static final double COUNTS_PER_REVOLUTION = 512;
	private static final double SPROCKET_DIAMETER = 2;
	private static final double SPROCKET_CIRCUMFERENCE = Math.PI * SPROCKET_DIAMETER;
	private static final double COUNTS_PER_INCH = 11500 / 35;
	private static final double ELEVATE_SPEED = 0.4;

	private static final double DEAD_ZONE = 0.1;
	private static final double MAX_DOWN_SPEED = 0.2;
	private static final double ELEVATOR_HEIGHT_THRESHOLD = 50;

	private static final double AUTONOMOUS_DEAD_ZONE_INCHES = 2;

	public Elevator() {
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new OperateElevator());
	}

	public double setDeadZone() {
		return DEAD_ZONE;
	}

	public double setAutoDeadZone() {
		return AUTONOMOUS_DEAD_ZONE_INCHES;
	}

	public double setDownSpeed() {
		return MAX_DOWN_SPEED;
	}

	public double getSetThreshold() {
		return ELEVATOR_HEIGHT_THRESHOLD;
	}

	public void elevatorPosition(double inchesToMove) {
		RobotMap.elevatorMotor.set(ControlMode.Position, inchesToMove * COUNTS_PER_INCH);
		System.out.println(inchesToMove * COUNTS_PER_INCH);
	}

	public void elevatorGoUp(double elevateSpeed) {
		RobotMap.elevatorMotor.set(elevateSpeed);
	}

	public void elevatorGoDown(double elevateSpeed) {
		RobotMap.elevatorMotor.set(-elevateSpeed);
	}

	public double getElevateSpeed() {
		return ELEVATE_SPEED;
	}

	public double getElevatorHeightInches() {
		double currentElevatorHeight = RobotMap.elevatorMotor.getSelectedSensorPosition(0);
		double elevatorHeight = currentElevatorHeight / COUNTS_PER_INCH;
		return elevatorHeight;
	}

	public void configElevatorEncoder() {
		RobotMap.elevatorMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);
		RobotMap.elevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		RobotMap.elevatorMotor.setSelectedSensorPosition(0, 0, 10);
		RobotMap.elevatorMotor.setSensorPhase(false);
		RobotMap.elevatorMotor.setSafetyEnabled(false);
		RobotMap.elevatorMotor.setInverted(true);
//		RobotMap.elevatorMotor.configClosedloopRamp(2, 10);
	}

	public void resetElevatorEncoder() {
		RobotMap.elevatorMotor.setSelectedSensorPosition(0, 0, 10);
	}

	public void stopElevator() {
		RobotMap.elevatorMotor.set(0);
	}
}