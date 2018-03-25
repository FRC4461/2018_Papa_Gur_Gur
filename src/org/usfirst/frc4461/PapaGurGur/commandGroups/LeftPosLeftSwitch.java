package org.usfirst.frc4461.PapaGurGur.commandGroups;

import org.usfirst.frc4461.PapaGurGur.commands.AutonomousElevator;
import org.usfirst.frc4461.PapaGurGur.commands.EncoderDrive;
import org.usfirst.frc4461.PapaGurGur.commands.OpenGripper;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * This Command group will allow for you to go to the LEFT_SWITCH when your
 * robot is positioned on the left.
 */
public class LeftPosLeftSwitch extends CommandGroup {

	public LeftPosLeftSwitch() {
		addSequential(AutonomousElevator.GoUp(5));
		addSequential(new EncoderDrive(102));
		addSequential(AutonomousElevator.GoUp(20));
		addSequential(new OpenGripper(3));
	}
}
