package org.usfirst.frc4461.PapaGurGur.subsystems;

import org.usfirst.frc4461.PapaGurGur.RobotMap;
import org.usfirst.frc4461.PapaGurGur.commands.OperateElevator;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {
    
    private static final double COUNTS_PER_REVOLUTION = 4096;
    private static final double SPROCKET_DIAMETER = 2;
    private static final double SPROCKET_CIRCUMFERENCE = Math.PI * SPROCKET_DIAMETER;
    private static final double COUNTS_PER_INCH = COUNTS_PER_REVOLUTION / SPROCKET_CIRCUMFERENCE;
    
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
    
    public double getElevatorHeightInches(){
	double getCurrentElevatorHeight = RobotMap.elevatorMotor.getSelectedSensorPosition(0);
	double elevatorHeight = getCurrentElevatorHeight / COUNTS_PER_INCH;
	return elevatorHeight;
    }
    
    public void resetElevatorEncoder(){
	RobotMap.elevatorMotor.setSelectedSensorPosition(0, 0, 10);
    }

    public void stopElevator() {
	RobotMap.elevatorMotor.set(0);
    }

}