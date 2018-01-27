// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4461.PapaGurGur.commands;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc4461.PapaGurGur.commands.GyroTurn;
import org.usfirst.frc4461.PapaGurGur.OI;
import org.usfirst.frc4461.PapaGurGur.Robot;

/**
 *
 */
public class Driving extends Command {

	GyroTurn turn;
	
    public Driving() {
        requires(Robot.driveBase);
    }

    protected void initialize() {
		turn = new GyroTurn();
    }

    protected void execute() {
    	double lSpeed = OI.lJoyGetY();
    	double rSpeed = OI.rJoyGetY();
    	Robot.driveBase.drive(lSpeed, rSpeed);

		System.out.println("Gyro angle returns: " + Robot.gyro.getAngle());
		
    	if(lSpeed + rSpeed > 0){
    		Robot.display.showMushroom();
    	}
    	else {
    		Robot.display.showFace();
    	}
    	
    	if(OI.lJoyTriggerDown()){
    		//turn.turn(90);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
