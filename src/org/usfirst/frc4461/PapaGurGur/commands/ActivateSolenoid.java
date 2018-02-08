package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 *
 */
public class ActivateSolenoid extends Command {

    public ActivateSolenoid() {
    }

    protected void initialize() {
    	System.out.println("It's running");
    }

    protected void execute() {
//    	RobotMap.compressor.setClosedLoopControl(true);    
    	RobotMap.doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    }

    protected boolean isFinished() {
        return false;
    }
    // end() never actually gets called because when the button is released it cancels the command
    // that means that interrupted() gets called instead. it does not end "naturally"
    protected void end() {
//    	RobotMap.compressor.setClosedLoopControl(false);
    	System.out.println("ending. going into reverse.");
    	RobotMap.doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    	
    }
    // TODO: read solenoid to see if it is actually going to go into reverse
    protected void interrupted() {
//    	RobotMap.compressor.setClosedLoopControl(false);
    	System.out.println("ending. going into reverse.");
    	RobotMap.doubleSolenoid.set(DoubleSolenoid.Value.kForward);
    }
}
