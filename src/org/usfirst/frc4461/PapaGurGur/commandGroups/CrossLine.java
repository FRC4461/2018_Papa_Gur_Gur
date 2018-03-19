package org.usfirst.frc4461.PapaGurGur.commandGroups;

import java.util.Optional;

import org.usfirst.frc4461.PapaGurGur.commands.AutonomousElevator;
import org.usfirst.frc4461.PapaGurGur.commands.EncoderDrive;
import org.usfirst.frc4461.PapaGurGur.commands.GyroTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Drives straight pretty much :-)
 */
public class CrossLine extends CommandGroup {

    public CrossLine() {
	addSequential(EncoderDrive.GoForwardInches(20, Optional.of(3)));
	addSequential(GyroTurn.turnLeft(90));
	addSequential(new AutonomousElevator(70));
    }
}
