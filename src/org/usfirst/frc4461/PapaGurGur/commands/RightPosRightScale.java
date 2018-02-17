package org.usfirst.frc4461.PapaGurGur.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightPosRightScale extends CommandGroup {

    public RightPosRightScale() {
    	addSequential(EncoderDrive.goForwardInches(324));
    	addSequential(GyroTurn.turnRight(90));
    	addSequential(EncoderDrive.goForwardInches(5));
    	addSequential(AutonomousElevator.goUp(55));
    	addSequential(EncoderDrive.goBackwardInches(5));
    	addSequential(GyroTurn.turnRight(90));
    	addSequential(AutonomousElevator.goDown(55));
    }
}
