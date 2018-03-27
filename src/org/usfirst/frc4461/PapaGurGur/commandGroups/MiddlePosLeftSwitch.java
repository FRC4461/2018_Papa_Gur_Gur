package org.usfirst.frc4461.PapaGurGur.commandGroups;

import org.usfirst.frc4461.PapaGurGur.commands.AutonomousElevator;
import org.usfirst.frc4461.PapaGurGur.commands.CloseGripper;
import org.usfirst.frc4461.PapaGurGur.commands.EncoderDrive;
import org.usfirst.frc4461.PapaGurGur.commands.GyroTurn;
import org.usfirst.frc4461.PapaGurGur.commands.OpenGripper;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MiddlePosLeftSwitch extends CommandGroup {

	public MiddlePosLeftSwitch() {
		addSequential(EncoderDrive.GoForward(30));
		addSequential(GyroTurn.turnLeft(90));
		addSequential(EncoderDrive.GoForward(50));
		addSequential(GyroTurn.turnRight(90));
		addParallel(AutonomousElevator.GoUp(45));
		addSequential(EncoderDrive.GoForward(150));
		addSequential(new OpenGripper(1));
		addParallel(AutonomousElevator.GoDown(0));
		addParallel(new CloseGripper(1));
		addSequential(EncoderDrive.GoBackward(30));
		addSequential(GyroTurn.turnLeft(90));
		addSequential(EncoderDrive.GoForward(60));
		addSequential(GyroTurn.turnRight(90));
		addSequential(EncoderDrive.GoForward(60));
	}
}
