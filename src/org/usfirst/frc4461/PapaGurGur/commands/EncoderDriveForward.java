package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class EncoderDriveForward extends Command {
	double distanceGoal;
	double speed = .25;
	boolean done;
	double currentDistance;

    public EncoderDriveForward(double target) {
    	distanceGoal = target; 
    	
    }

    protected void initialize() {
    	RobotMap.encoder.reset();
    	System.out.println(RobotMap.encoder.get());
    	System.out.println("encoder initialize");
    }

    protected void execute() {
    	double currentDistance = RobotMap.encoder.getDistance(); 
    	double distance = RobotMap.encoder.get();
    	if (currentDistance < distanceGoal){
    		RobotMap.frontLeft.set(-speed);
    		RobotMap.backLeft.set(-speed);
    		RobotMap.frontRight.set(speed);
    		RobotMap.backRight.set(speed);
    		System.out.println("current Distnace" +currentDistance);
    		System.out.println("distance" + distance);
    	} else if ( currentDistance >= distanceGoal){
    		RobotMap.frontLeft.set(0);
    		RobotMap.backLeft.set(0);
    		RobotMap.frontRight.set(0);
    		RobotMap.backRight.set(0);
    		done = true; 
    	}
    }

    protected boolean isFinished() {
        return done;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
