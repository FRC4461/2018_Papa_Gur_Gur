package org.usfirst.frc4461.PapaGurGur.commands;
import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousCommand extends Command {
	
    public AutonomousCommand() {
    	
    }

    protected void initialize() {
    }

    protected void execute() {
    	double currentAngle = Robot.gyro.getAngle();
    	System.out.println(currentAngle);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
