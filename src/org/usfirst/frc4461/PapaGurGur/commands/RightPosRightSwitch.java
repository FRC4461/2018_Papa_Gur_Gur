package org.usfirst.frc4461.PapaGurGur.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightPosRightSwitch extends CommandGroup {

    public RightPosRightSwitch() {
    	addSequential(EncoderDrive.goForwardInches(146));
    	addSequential(new Delay(0));
    	addSequential(GyroTurn.turnLeft(90));
    	addSequential(new Delay(0));
    	addSequential(EncoderDrive.goForwardInches(33.56));
    	addSequential(new Delay(0));
    	addSequential(AutonomousElevator.goUp(20));
    	addSequential(new PlaceCube());
    	addSequential(new CloseGripper());
    	addSequential(AutonomousElevator.goDown(20));
    }
}
