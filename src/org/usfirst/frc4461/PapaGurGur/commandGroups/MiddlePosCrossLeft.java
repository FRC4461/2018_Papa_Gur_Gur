package org.usfirst.frc4461.PapaGurGur.commandGroups;

import org.usfirst.frc4461.PapaGurGur.commands.EncoderDrive;
import org.usfirst.frc4461.PapaGurGur.commands.GyroTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MiddlePosCrossLeft extends CommandGroup {

    public MiddlePosCrossLeft() {
        addSequential(EncoderDrive.GoForward(130));
    }
}
