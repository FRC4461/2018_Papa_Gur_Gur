package org.usfirst.frc4461.PapaGurGur.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class EncoderForward extends CommandGroup {

    public EncoderForward() {
    	addSequential(new EncoderDriveForward(.1));
    }  
}
