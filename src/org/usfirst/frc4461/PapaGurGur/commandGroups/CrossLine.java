package org.usfirst.frc4461.PapaGurGur.commandGroups;

import org.usfirst.frc4461.PapaGurGur.commands.EncoderDrive;
import org.usfirst.frc4461.PapaGurGur.commands.GyroTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Drives straight pretty much :-)
 */
public class CrossLine extends CommandGroup {

    public CrossLine() {
	addSequential(new EncoderDrive(20,3));
	addSequential(GyroTurn.turnLeft(90));
    }
}
