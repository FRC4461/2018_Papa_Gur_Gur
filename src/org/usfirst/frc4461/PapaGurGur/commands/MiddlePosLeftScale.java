package org.usfirst.frc4461.PapaGurGur.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Drops power cube on the wide side of the scale
 *
 */
public class MiddlePosLeftScale extends CommandGroup {

    public MiddlePosLeftScale() {
    	addSequential(EncoderDrive.goForwardInches(50));
    	addSequential(GyroTurn.turnLeft(90));
    	addSequential(EncoderDrive.goForwardInches(132));
    	addSequential(GyroTurn.turnLeft(90));
    	addSequential(EncoderDrive.goForwardInches(132));
    	addSequential(GyroTurn.turnRight(90));
    	addSequential(EncoderDrive.goForwardInches(15));
    	addSequential(AutonomousElevator.goUp(55));
    	addSequential(new PlaceCube());
    }
}
