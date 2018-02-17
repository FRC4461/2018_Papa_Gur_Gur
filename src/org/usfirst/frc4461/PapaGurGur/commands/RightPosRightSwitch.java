package org.usfirst.frc4461.PapaGurGur.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightPosRightSwitch extends CommandGroup {

    public RightPosRightSwitch() {
    	addSequential(EncoderDrive.goForwardInches(100));
    	//DROP CUBE CODE HERE
    	addSequential(EncoderDrive.goBackwardInches(10));
    	addSequential(GyroTurn.turnRight(90));
    	addSequential(EncoderDrive.goForwardInches(40));
    	addSequential(EncoderDrive.goForwardInches(100));
    }
}
