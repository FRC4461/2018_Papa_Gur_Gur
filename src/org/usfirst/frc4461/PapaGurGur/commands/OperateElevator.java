package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.OI;
import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OperateElevator extends Command {
    /**
     * Command for operating the elevator. The A button brings the elevator up,
     * the B button brings the elevator down.
     */
    public OperateElevator() {
	requires(Robot.elevator);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
	double elevateSpeed = 0.6;

	if (OI.isAButtonPressed()) {
	    Robot.elevator.elevatorGoUp(.6);
	} else if (OI.isBButtonPressed()) {
	    Robot.elevator.elevatorGoDown(.2);
	} else {
	    Robot.elevator.stopElevator();
	}
    }

    @Override
    protected boolean isFinished() {
	return false;
    }

    @Override
    protected void end() {
	Robot.elevator.stopElevator();
    }

    @Override
    protected void interrupted() {
	end();
    }
}
