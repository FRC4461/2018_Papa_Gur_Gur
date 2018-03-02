package org.usfirst.frc4461.PapaGurGur.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MiddlePosRightScale extends CommandGroup {

    public MiddlePosRightScale() {
    	addSequential(EncoderDrive.goForwardInches(28));
    	addSequential(GyroTurn.turnRight(90));
    	addSequential(EncoderDrive.goForwardInches(132));
    	addSequential(GyroTurn.turnLeft(90));
    	addSequential(EncoderDrive.goForwardInches(274));
    	addSequential(GyroTurn.turnLeft(90));
    	addSequential(EncoderDrive.goForwardInches(15));
    	addSequential(AutonomousElevator.goUp(55));
    	addSequential(new PlaceCube());
    	addSequential(new CloseGripper());
    	addSequential(AutonomousElevator.goDown(55));
    }
}
