package org.usfirst.frc4461.PapaGurGur.subsystems;

import org.usfirst.frc4461.PapaGurGur.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gyro extends Subsystem {

    @Override
    public void initDefaultCommand() {
    }

    public double getAngle() {
	return RobotMap.gyro.getAngle();
    }

    public void resetGyro() {
	RobotMap.gyro.reset();
    }
}
