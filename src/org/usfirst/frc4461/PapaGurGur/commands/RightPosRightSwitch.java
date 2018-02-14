package org.usfirst.frc4461.PapaGurGur.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightPosRightSwitch extends CommandGroup {

    public RightPosRightSwitch() {
    	addSequential(new EncoderDriveForward(100));
    	//DROP CUBE CODE HERE
    	addSequential(new EncoderDriveForward(-10));
    	addSequential(new GyroTurn(90));
    	addSequential(new EncoderDriveForward(40));
    	addSequential(new EncoderDriveForward(100));
    }
}
