package org.usfirst.frc4461.PapaGurGur.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftPosLeftScale extends CommandGroup {

    public LeftPosLeftScale() {
    	addSequential(EncoderDrive.goForwardInches(302));
    	addSequential(new Delay(0));
    	addSequential(GyroTurn.turnRight(90));
    	addSequential(new Delay(0));
    	addSequential(AutonomousElevator.goUp(55));
    	addSequential(new Delay(0));
    	addSequential(EncoderDrive.goForwardInches(5));
    	addSequential(new Delay(0));
    	addSequential(new PlaceCube());
    	addSequential(new CloseGripper());
    	addSequential(EncoderDrive.goBackwardInches(5));
    	addSequential(AutonomousElevator.goDown(55));
    }
}
