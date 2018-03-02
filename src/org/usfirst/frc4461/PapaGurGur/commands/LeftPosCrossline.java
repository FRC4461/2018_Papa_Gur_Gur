package org.usfirst.frc4461.PapaGurGur.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftPosCrossline extends CommandGroup {

    public LeftPosCrossline() {
    	addSequential(EncoderDrive.goForwardInches(200));
    }
}
