package org.usfirst.frc4461.PapaGurGur.subsystems;

import org.usfirst.frc4461.PapaGurGur.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GripMotors extends Subsystem {

    private static final double MOTOR_SPEED = 0.6;

    public void runIntake() {
	RobotMap.gripMotor1.set(MOTOR_SPEED);
	RobotMap.gripMotor2.set(MOTOR_SPEED);
    }

    public void runOuttake() {
	RobotMap.gripMotor1.set(-MOTOR_SPEED);
	RobotMap.gripMotor2.set(-MOTOR_SPEED);
    }

    public void stopMotors() {
	RobotMap.gripMotor1.set(0);
	RobotMap.gripMotor2.set(0);
    }

    public void initDefaultCommand() {

    }
}
