package org.usfirst.frc4461.PapaGurGur.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightPosRightScale extends CommandGroup {

    public RightPosRightScale() {
    	addSequential(new EncoderDriveForward(324));
    	addSequential(new GyroTurn(-90));
    	addSequential(new EncoderDriveForward(5));
    	//ADD DROP CUBE CODE HERE
    }
}
