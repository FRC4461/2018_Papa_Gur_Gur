package org.usfirst.frc4461.PapaGurGur.commandGroups;

import org.usfirst.frc4461.PapaGurGur.commands.AutonomousElevator;
import org.usfirst.frc4461.PapaGurGur.commands.EncoderDrive;
import org.usfirst.frc4461.PapaGurGur.commands.OpenGripper;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * This Command group will allow for you to go to the RIGHT_SWITCH when your
 * robot is positioned on the right.
 */
public class RightPosRightSwitch extends CommandGroup {

	public RightPosRightSwitch() {
		addSequential(AutonomousElevator.GoUp(30));
		addSequential(new EncoderDrive(135 - 37));
	}
}
