package org.usfirst.frc4461.PapaGurGur.commandGroups;

import org.usfirst.frc4461.PapaGurGur.commands.AutonomousElevator;
import org.usfirst.frc4461.PapaGurGur.commands.EncoderDrive;
import org.usfirst.frc4461.PapaGurGur.commands.GyroTurn;
import org.usfirst.frc4461.PapaGurGur.commands.OpenGripper;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightPosLeftSwitch extends CommandGroup {

    public RightPosLeftSwitch() {
		addSequential(new EncoderDrive(40));
		addSequential(GyroTurn.turnLeft(90));
		addSequential(new EncoderDrive(140));
		addSequential(GyroTurn.turnRight(90));
		addParallel(AutonomousElevator.GoUp(45));
		addSequential(new EncoderDrive(53));
		addSequential(new OpenGripper(2));
    }
}
