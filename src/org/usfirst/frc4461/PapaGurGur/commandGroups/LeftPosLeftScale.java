package org.usfirst.frc4461.PapaGurGur.commandGroups;

import org.usfirst.frc4461.PapaGurGur.commands.GyroTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * This Command group will allow for you to go to the LEFT_SCALE when your robot
 * is positioned on the left.
 */
public class LeftPosLeftScale extends CommandGroup {

    public LeftPosLeftScale() {
    	addSequential(GyroTurn.turnLeft(90));
    	addSequential(GyroTurn.turnRight(90));
    }
}