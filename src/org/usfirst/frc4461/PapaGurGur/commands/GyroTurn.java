package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;
import org.usfirst.frc4461.PapaGurGur.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class GyroTurn extends Command {
	private double degreesToTurn;
	private boolean done = false;
	private static final double DEAD_ZONE = 1;
	private static final double SPEED = .25;
	
    public GyroTurn(double numberOfDegreesToTurn){
    	degreesToTurn = numberOfDegreesToTurn;
    }

    protected void initialize() {
    	RobotMap.gyro.reset();
    	System.out.println("Yes its working");
    }

    protected void execute() {
    	double facing = RobotMap.gyro.getAngle();    	
    	if(Math.abs(facing) > (Math.abs(degreesToTurn) - DEAD_ZONE) && Math.abs(facing) < (Math.abs(degreesToTurn) + DEAD_ZONE)) {
    		RobotMap.frontLeft.set(0);
    		RobotMap.backLeft.set(0);	
    		RobotMap.frontRight.set(0);
    		RobotMap.backRight.set(0);
    		done = true;
    	}
    	else if(facing < degreesToTurn){
			RobotMap.frontLeft.set(SPEED);
			RobotMap.backLeft.set(SPEED);	
			RobotMap.frontRight.set(SPEED);
			RobotMap.backRight.set(SPEED);
			System.out.println("Facing " + facing);
			System.out.println("we are going to the RIGHT");
    	}
    	else if(facing > degreesToTurn){
			RobotMap.frontLeft.set(-SPEED);
			RobotMap.backLeft.set(-SPEED);	
			RobotMap.frontRight.set(-SPEED);
			RobotMap.backRight.set(-SPEED);
			System.out.println("Facing " + facing);
			System.out.println("we are going to the left");
    	}
    }

    protected boolean isFinished() {
    	return done;
    }

    protected void end() {
		RobotMap.frontLeft.set(0);
		RobotMap.backLeft.set(0);	
		RobotMap.frontRight.set(0);
		RobotMap.backRight.set(0);
    	end();
    }
}
