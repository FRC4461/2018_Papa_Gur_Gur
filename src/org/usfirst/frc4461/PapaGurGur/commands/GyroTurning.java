package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.RobotMap;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.interfaces.Gyro;


public class GyroTurning {
	double currentAngle;
	Gyro gyro;
	boolean isDone;
	double kAngleSetpoint = 0.0;
	
	
	public GyroTurning(){
		gyro = new AnalogGyro(1);
	}

	
	public void nintit(){
		gyro.reset();
		double angle = gyro.getAngle();
		double turningValue = (kAngleSetpoint - gyro.getAngle()) * .003;
		System.out.println(turningValue);

		double time = System.currentTimeMillis();
		
		
		RobotMap.frontLeft.set(.1);
		RobotMap.backLeft.set(.1);	
		RobotMap.frontRight.set(-.1);
		RobotMap.backRight.set(-.1);

	}

	public void turn(double turnAngle){
		currentAngle = gyro.getAngle();
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
			currentAngle = gyro.getAngle();
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
