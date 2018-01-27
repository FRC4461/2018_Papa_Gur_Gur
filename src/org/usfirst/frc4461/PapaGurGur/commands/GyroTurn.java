package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class GyroTurn extends Command {
	double currentAngle;
	boolean isDone;
	double kAngleSetpoint = 0.0;
	double degree;
	double facing;
	boolean done = false;
	double deadzone = 1;
	double speed = .25;
	
    public GyroTurn(double input){
    	degree = input;
    }

    protected void initialize() {
    	RobotMap.gyro.reset();
    	System.out.println("Yes its working");
    }

    protected void execute() {
    	facing = RobotMap.gyro.getAngle();    	
    	if(facing > (degree - deadzone) && facing < (degree + deadzone)) {
    		RobotMap.frontLeft.set(0);
    		RobotMap.backLeft.set(0);	
    		RobotMap.frontRight.set(0);
    		RobotMap.backRight.set(0);
    		done = true;
    	}
    	else if(facing < (degree) + deadzone){
			RobotMap.frontLeft.set(speed);
			RobotMap.backLeft.set(speed);	
			RobotMap.frontRight.set(speed);
			RobotMap.backRight.set(speed);
			System.out.println("Facing " + facing);
			System.out.println("we are going to the RIGHT");
    	}
    	else if(facing > (degree) - deadzone){
			RobotMap.frontLeft.set(-speed);
			RobotMap.backLeft.set(-speed);	
			RobotMap.frontRight.set(-speed);
			RobotMap.backRight.set(-speed);
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
