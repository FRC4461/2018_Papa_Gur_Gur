package org.usfirst.frc4461.PapaGurGur.commandGroups;

import org.usfirst.frc4461.PapaGurGur.commands.AutonomousElevator;
import org.usfirst.frc4461.PapaGurGur.commands.Delay;
import org.usfirst.frc4461.PapaGurGur.commands.EncoderDrive;
import org.usfirst.frc4461.PapaGurGur.commands.GyroTurn;
import org.usfirst.frc4461.PapaGurGur.commands.OpenGripper;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * This Command group will allow for you to go to the RIGHT_SCALE when your
 * robot is positioned on the right.
 */
public class RightPosRightScale extends CommandGroup {

	public RightPosRightScale() {
		addSequential(new EncoderDrive(264));
		addParallel(AutonomousElevator.GoUp(101));
		addSequential(GyroTurn.turnLeft(45));
		addSequential(new EncoderDrive(58));
		addSequential(new Delay(1.5));
		addSequential(new OpenGripper(2));
//		addSequential(new EncoderDrive(112));
//		addSequential(GyroTurn.turnLeft(180));

	}
}
