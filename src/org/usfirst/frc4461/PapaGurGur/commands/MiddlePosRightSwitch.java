package org.usfirst.frc4461.PapaGurGur.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MiddlePosRightSwitch extends CommandGroup {

    public MiddlePosRightSwitch() {
    	addSequential(EncoderDrive.goForwardInches(38));
    	addSequential(new Delay(0));
    	addSequential(GyroTurn.turnRight(90));
    	addSequential(new Delay(0));
    	addSequential(EncoderDrive.goForwardInches(40));
    	addSequential(new Delay(0));
    	addSequential(GyroTurn.turnLeft(90));
    	addSequential(new Delay(0));
    	addSequential(EncoderDrive.goForwardInches(80));
    	addSequential(new Delay(0));
    	addSequential(AutonomousElevator.goUp(20));
    	addSequential(new PlaceCube());
    	addSequential(new CloseGripper());
    	addSequential(AutonomousElevator.goDown(20));
    }
}
