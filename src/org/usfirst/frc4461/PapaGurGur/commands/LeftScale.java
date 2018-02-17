package org.usfirst.frc4461.PapaGurGur.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftScale extends CommandGroup {

    public LeftScale() {
    	addSequential(EncoderDrive.goForwardInches(50));
    }
}
