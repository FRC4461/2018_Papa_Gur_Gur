package org.usfirst.frc4461.PapaGurGur.commandGroups;

import org.usfirst.frc4461.PapaGurGur.commands.EncoderDrive;
import org.usfirst.frc4461.PapaGurGur.commands.GyroTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * This Command group will allow for you to go to the RIGHT_SCALE when your
 * robot is positioned on the right.
 */
public class RightPosRightScale extends CommandGroup {

	public RightPosRightScale() {
		addSequential(new EncoderDrive(112));
		addSequential(GyroTurn.turnRight(90));
		addSequential(new EncoderDrive(112));
		addSequential(GyroTurn.turnLeft(180));
	}
}
