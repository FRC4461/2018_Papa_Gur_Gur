package org.usfirst.frc4461.PapaGurGur.commandGroups;

import java.util.Optional;

import org.usfirst.frc4461.PapaGurGur.commands.AutonomousElevator;
import org.usfirst.frc4461.PapaGurGur.commands.CloseGripper;
import org.usfirst.frc4461.PapaGurGur.commands.EncoderDrive;
import org.usfirst.frc4461.PapaGurGur.commands.GyroTurn;
import org.usfirst.frc4461.PapaGurGur.commands.OpenGripper;
import org.usfirst.frc4461.PapaGurGur.commands.RunIntakeMotors;
import org.usfirst.frc4461.PapaGurGur.commands.RunOuttakeMotors;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Drives straight pretty much :-)
 */
public class CrossLine extends CommandGroup {

	public CrossLine() {
		addSequential(new EncoderDrive(145));
	}

}