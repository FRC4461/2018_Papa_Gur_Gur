package org.usfirst.frc4461.PapaGurGur.commandGroups;

import org.usfirst.frc4461.PapaGurGur.commands.AutonomousElevator;
import org.usfirst.frc4461.PapaGurGur.commands.CloseGripper;
import org.usfirst.frc4461.PapaGurGur.commands.EncoderDrive;
import org.usfirst.frc4461.PapaGurGur.commands.GyroTurn;
import org.usfirst.frc4461.PapaGurGur.commands.OpenGripper;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * This Command group will allow for you to go to the LEFT_SWITCH when your
 * robot is positioned on the left.
 */
public class LeftPosLeftSwitch extends CommandGroup {

	public LeftPosLeftSwitch() {
		addParallel(AutonomousElevator.GoUp(45));
		addSequential(EncoderDrive.GoForward(135 - 37 + 6 + 5));
		addSequential(new OpenGripper(2));
		addSequential(EncoderDrive.GoBackward(30));
		addParallel(new CloseGripper(1));
		addParallel(AutonomousElevator.GoDown(0));
		addSequential(GyroTurn.turnLeft(90));
		addSequential(EncoderDrive.GoForward(40));
		addSequential(GyroTurn.turnRight(90));
		addSequential(EncoderDrive.GoForward(60));
	}
}
