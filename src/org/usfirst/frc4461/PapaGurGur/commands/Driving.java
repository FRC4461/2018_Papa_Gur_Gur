package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.OI;
import org.usfirst.frc4461.PapaGurGur.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Driving extends Command {

    private static final double ELEVATOR_HEIGHT_THRESHOLD = 50;
    
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
	
	Robot.driveBase.drive(lSpeed, rSpeed);
	if(elevatorHeight > ELEVATOR_HEIGHT_THRESHOLD ){
	}
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
