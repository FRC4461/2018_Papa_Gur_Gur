package org.usfirst.frc4461.PapaGurGur.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightPosCrossline extends CommandGroup {

    public RightPosCrossline() {
    	addSequential(EncoderDrive.goForwardInches(200));
    }
}
