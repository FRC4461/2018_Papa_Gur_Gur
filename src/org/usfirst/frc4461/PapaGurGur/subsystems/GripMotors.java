package org.usfirst.frc4461.PapaGurGur.subsystems;

import org.usfirst.frc4461.PapaGurGur.RobotMap;
import org.usfirst.frc4461.PapaGurGur.commands.OperateGripMotors;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GripMotors extends Subsystem {

    private static final double INTAKE_SPEED = 0.75;
    private static final double OUTTAKE_SPEED = -1;

    public void runIntake() {
	RobotMap.gripMotor1.set(INTAKE_SPEED);
	RobotMap.gripMotor2.set(INTAKE_SPEED);
    }

    public void runOuttake() {
	RobotMap.gripMotor1.set(OUTTAKE_SPEED);
	RobotMap.gripMotor2.set(OUTTAKE_SPEED);
    }

    public void stopMotors() {
	RobotMap.gripMotor1.set(0);
	RobotMap.gripMotor2.set(0);
    }

    public void initDefaultCommand() {
	setDefaultCommand(new OperateGripMotors());
    }
}
