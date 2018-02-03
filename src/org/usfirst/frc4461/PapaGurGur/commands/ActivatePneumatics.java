package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ActivatePneumatics extends Command {

    public ActivatePneumatics() {
    }

    protected void initialize() {
    }

    protected void execute() {
    	RobotMap.compressor.setClosedLoopControl(true);
    	System.out.println("It's running");
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	RobotMap.compressor.setClosedLoopControl(false);
    }

    protected void interrupted() {
    }
}
