package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;
import org.usfirst.frc4461.PapaGurGur.RobotMap;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousElevator extends Command {


	private static final int COUNTS_PER_REVOLUTION = 4096;
	private static final double WHEEL_CIRCUMFERENCE = 6 * Math.PI;
	private static final double GEAR_REDUCTION = (45/19)*(50 / 14);
	/** Number of encoder ticks per inch */
	private static final double COUNTS_PER_INCH = 	COUNTS_PER_REVOLUTION * GEAR_REDUCTION / WHEEL_CIRCUMFERENCE;
	private static final int DEAD_ZONE = (int)COUNTS_PER_INCH * 3;
	private double countsToMove;
	
    private AutonomousElevator(double inchesToMove) {
    	countsToMove = inchesToMove * COUNTS_PER_INCH;
    }

    public static AutonomousElevator goDown(double countsToMove){
    	return new AutonomousElevator(-countsToMove);
    }
    
    public static AutonomousElevator goUp(double countsToMove){
    	return new AutonomousElevator(countsToMove);
    }

    protected void initialize() {
    	RobotMap.elevatorMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 1);
    	RobotMap.elevatorMotor.setSelectedSensorPosition(0, 0, 1);
    	RobotMap.elevatorMotor.setSensorPhase(true);
    	RobotMap.elevatorMotor.setSafetyEnabled(false);
    	System.out.println("Elevator Encoder Initialized");
    }

    public void execute(){
    	Robot.elevator.setElevatorUpSpeed(countsToMove);
    }

    protected boolean isFinished() {
    	if (RobotMap.elevatorMotor.getSelectedSensorPosition(0) > countsToMove - DEAD_ZONE &&
			RobotMap.elevatorMotor.getSelectedSensorPosition(0) < countsToMove + DEAD_ZONE) {
        	System.out.println("Done");
    		return true;
    	}
        return false;
    }

    protected void end() {
    	RobotMap.backLeft.setSafetyEnabled(true);
    	RobotMap.backRight.setInverted(false);
    	RobotMap.frontRight.setInverted(false);
    	System.out.println(RobotMap.backLeft.getSelectedSensorPosition(0));
    }
    
    protected void interrupted() {
    }
}
