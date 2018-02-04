package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 *
 */
public class ActivatePneumatics extends Command {

    public ActivatePneumatics() {
    }

    protected void initialize() {
    }

    protected void execute() {
    	RobotMap.doubleSolenoid.set(DoubleSolenoid.Value.kForward);
    	System.out.println("It's running");
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	RobotMap.doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

    protected void interrupted() {
    }
}
