package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;
import org.usfirst.frc4461.PapaGurGur.RobotMap;

public class GyroTurn {
	double currentAngle;
	boolean isDone;
	double kAngleSetpoint = 0.0;
	
	public GyroTurn(){
	}

	public void turn(double turnAngle){
		currentAngle = Robot.gyro.getAngle();
		double turnGoal = currentAngle + turnAngle;

		isDone = false;

		if (currentAngle < turnGoal){
			rightTurn(turnGoal);
		} else if( currentAngle > turnGoal){
			leftTurn(turnGoal);
		} else{
			System.out.println("we're already there, you dink");
		}
	}

	public void rightTurn(double turnGoal){
		while(!isDone){
			currentAngle = Robot.gyro.getAngle();
			System.out.println(currentAngle);
			if(currentAngle < turnGoal * (3/5)){
				RobotMap.frontLeft.set(.01);
				RobotMap.backLeft.set(.01);	
				RobotMap.frontRight.set(.01);
				RobotMap.backRight.set(.01);
			}
			else if(currentAngle < turnGoal * (4/5)){
				RobotMap.frontLeft.set(.01);
				RobotMap.backLeft.set(.01);
				RobotMap.frontRight.set(.01);
				RobotMap.backRight.set(.01);
			}
			else if(currentAngle >= turnGoal){
				RobotMap.frontLeft.set(0);
				RobotMap.backLeft.set(0);	
				RobotMap.frontRight.set(0);
				RobotMap.backRight.set(0);				
				isDone = true;
			}
		}
	}

	public void leftTurn(double turnGoal){
		while(!isDone){
			// do the opposite of turn right ya feel
		}
	}
}
