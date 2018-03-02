package org.usfirst.frc4461.PapaGurGur.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftPosLeftSwitch extends CommandGroup {

    public LeftPosLeftSwitch() {
    	addSequential(EncoderDrive.goForwardInches(146));
    	addSequential(new Delay(0));
    	addSequential(GyroTurn.turnRight(90));
    	addSequential(new Delay(0));
    	addSequential(EncoderDrive.goForwardInches(33.56));
    	addSequential(new Delay(0));
    	addSequential(AutonomousElevator.goUp(20));
    	addSequential(new PlaceCube());
    	addSequential(new CloseGripper());
    	addSequential(AutonomousElevator.goDown(20));
    }
}
