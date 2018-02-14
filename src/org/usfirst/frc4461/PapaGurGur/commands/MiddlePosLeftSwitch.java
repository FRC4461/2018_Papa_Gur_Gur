package org.usfirst.frc4461.PapaGurGur.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Drops off power cube on the short side of the switch
 *
 */
public class MiddlePosLeftSwitch extends CommandGroup {

    public MiddlePosLeftSwitch() {
    	addSequential(new EncoderDriveForward(60));
    	addSequential(new GyroTurn(-90));
    	addSequential(new EncoderDriveForward(40));
    	addSequential(new GyroTurn(90));
    	addSequential(new EncoderDriveForward(80));
    	// add sequential elevator
    	// add sequential drop
    	addSequential(new GyroTurn(-90));
    	// Double check this will be enough/overboard to pass switch
    	addSequential(new EncoderDriveForward(40));
    	addSequential(new GyroTurn(90));
    	// Double check this will be enough/overboard to pass line
    	addSequential(new EncoderDriveForward(50));
    }
}
