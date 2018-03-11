package org.usfirst.frc4461.PapaGurGur.subsystems;

import org.usfirst.frc4461.PapaGurGur.RobotMap;
import org.usfirst.frc4461.PapaGurGur.commands.GripperPneumatics;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gripper extends Subsystem {
	public Gripper() {
	}

	protected void initDefaultCommand() {
		setDefaultCommand(new GripperPneumatics());
	}
	
	public void runIntake() {
		RobotMap.gripMotor1.set(-0.3);
		RobotMap.gripMotor2.set(0.3);
	}
	
	public void runOuttake() {
		RobotMap.gripMotor1.set(0.3);
		RobotMap.gripMotor2.set(-0.3);
	}
	
	public void stopMotors() {
		RobotMap.gripMotor1.set(0);
		RobotMap.gripMotor2.set(0);
	}
}

