package org.usfirst.frc4461.PapaGurGur.commandGroups;

import org.usfirst.frc4461.PapaGurGur.commands.EncoderDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Drives straight pretty much :-)
 */
public class CrossLine extends CommandGroup {

    public CrossLine() {
	addSequential(new EncoderDrive(100));
    }
}
