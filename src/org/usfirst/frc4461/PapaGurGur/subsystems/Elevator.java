package org.usfirst.frc4461.PapaGurGur.subsystems;

import org.usfirst.frc4461.PapaGurGur.RobotMap;
import org.usfirst.frc4461.PapaGurGur.commands.OperateElevator;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {

    private static final double COUNTS_PER_REVOLUTION = 4096;
    private static final double SPROCKET_DIAMETER = 2;
    private static final double SPROCKET_CIRCUMFERENCE = Math.PI * SPROCKET_DIAMETER;
    private static final double COUNTS_PER_INCH = COUNTS_PER_REVOLUTION / SPROCKET_CIRCUMFERENCE;
    private static final double ELEVATE_SPEED = 0.4;

    public Elevator() {
    }

    @Override
    protected void initDefaultCommand() {
	setDefaultCommand(new OperateElevator());
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
	double getCurrentElevatorHeight = RobotMap.elevatorMotor.getSelectedSensorPosition(0);
	double elevatorHeight = getCurrentElevatorHeight / COUNTS_PER_INCH;
	return elevatorHeight;
    }

    public void configElevatorEncoder() {
	RobotMap.elevatorMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1, 10);
	RobotMap.elevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
	RobotMap.elevatorMotor.setSelectedSensorPosition(0, 0, 10);
	RobotMap.elevatorMotor.setSensorPhase(true);
	RobotMap.elevatorMotor.setSafetyEnabled(false);
    }

    public void resetElevatorEncoder() {
	RobotMap.elevatorMotor.setSelectedSensorPosition(0, 0, 10);
    }

    public void stopElevator() {
	RobotMap.elevatorMotor.set(0);
    }
}