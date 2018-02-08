package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ActivateCompressor extends Command {

    public ActivateCompressor() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    protected void initialize() {
    	System.out.println("It's running");
    }

    protected void execute() {
    	RobotMap.compressor.setClosedLoopControl(true);    
    }

    protected boolean isFinished() {
        return false;
    }
    // end() never actually gets called because when the button is released it cancels the command
    // that means that interrupted() gets called instead. it does not end "naturally"
    protected void end() {
    	RobotMap.compressor.setClosedLoopControl(false);
    	System.out.println("ending. going into reverse.");
    	
    }
    // TODO: read solenoid to see if it is actually going to go into reverse
    protected void interrupted() {
    	RobotMap.compressor.setClosedLoopControl(false);
    	System.out.println("ending. going into reverse.");
    }
}
