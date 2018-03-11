package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.OI;
import org.usfirst.frc4461.PapaGurGur.Robot;
import org.usfirst.frc4461.PapaGurGur.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Driving extends Command {

    public Driving() {
	requires(Robot.driveBase);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
	double lSpeed = OI.lJoyGetY();
	double rSpeed = OI.rJoyGetY();
	Robot.driveBase.drive(lSpeed, rSpeed);

	System.out.println("Left: " + RobotMap.frontLeft.getSelectedSensorPosition(0));
	System.out.println("Right: " + RobotMap.frontRight.getSelectedSensorPosition(0));
    }

    @Override
    protected boolean isFinished() {
	return false;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    }
}
