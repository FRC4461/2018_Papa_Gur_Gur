package org.usfirst.frc4461.PapaGurGur.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Drops off power cube on the short side of the switch
 *
 */
public class MiddlePosLeftSwitch extends CommandGroup {

    public MiddlePosLeftSwitch() {
    	addSequential(EncoderDrive.goForwardInches(60));
    	addSequential(GyroTurn.turnLeft(90));
    	addSequential(EncoderDrive.goForwardInches(40));
    	addSequential(GyroTurn.turnRight(90));
    	addSequential(EncoderDrive.goForwardInches(40));
    	// add sequential elevator
    	// add sequential drop
    	addSequential(GyroTurn.turnLeft(90));
    	// Double check this will be enough/overboard to pass switch
    	addSequential(EncoderDrive.goForwardInches(40));
    	addSequential(GyroTurn.turnRight(90));
    	// Double check this will be enough/overboard to pass line
    	addSequential(EncoderDrive.goForwardInches(40));
    }
}
