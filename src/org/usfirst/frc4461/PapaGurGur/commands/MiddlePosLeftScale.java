package org.usfirst.frc4461.PapaGurGur.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Drops power cube on the wide side of the scale
 *
 */
public class MiddlePosLeftScale extends CommandGroup {

    public MiddlePosLeftScale() {
    	addSequential(new EncoderDriveForward(50));
    	addSequential(new GyroTurn(-90));
    	addSequential(new EncoderDriveForward(132));
    	addSequential(new GyroTurn(90));
    	addSequential(new EncoderDriveForward(274));
    	addSequential(new GyroTurn(90));
    	addSequential(new EncoderDriveForward(15));
    	//add sequential elevator
    	//add sequential drop
    }
}
