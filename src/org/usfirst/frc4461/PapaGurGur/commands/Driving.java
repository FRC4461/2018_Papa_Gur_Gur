package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.OI;
import org.usfirst.frc4461.PapaGurGur.Robot;
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
	double elevatorHeight = Robot.elevator.getElevatorHeightInches();
	double elevatorHeightThreshold = Robot.elevator.setThreshold();
	double slowMultiplier = Robot.driveBase.slowMultiplier();

	if (elevatorHeight > elevatorHeightThreshold) {
	    lSpeed *= slowMultiplier;
	    rSpeed *= slowMultiplier;
	}
	Robot.driveBase.drive(lSpeed, rSpeed);
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
