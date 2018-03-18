package org.usfirst.frc4461.PapaGurGur.commandGroups;

import org.usfirst.frc4461.PapaGurGur.commands.EncoderDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class KnockCube extends CommandGroup {

    public KnockCube() {
	addSequential(new EncoderDrive(60));
    }
}
