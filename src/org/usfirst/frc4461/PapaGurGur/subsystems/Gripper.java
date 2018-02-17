package org.usfirst.frc4461.PapaGurGur.subsystems;

import org.usfirst.frc4461.PapaGurGur.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gripper extends Subsystem {
	
	private final static double INTAKE_SPEED = -.6;
	private final static double OUTTAKE_SPEED = .6;
	
	public Gripper() {
	}
	
	public void RunIntakeMotors(){
		RobotMap.gripMotor1.set(INTAKE_SPEED);
		RobotMap.gripMotor2.set(INTAKE_SPEED);
	}
	public void OpenGripper(){
		RobotMap.doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void CloseGripper(){
		RobotMap.doubleSolenoid.set(DoubleSolenoid.Value.kForward);
	}
	
	public void RunOuttakeMotors(){
		RobotMap.gripMotor1.set(OUTTAKE_SPEED);
	}
	
	public void stopMotors(){
		RobotMap.gripMotor1.set(0);
		RobotMap.gripMotor1.set(0);
	}

	protected void initDefaultCommand() {
	}
}

