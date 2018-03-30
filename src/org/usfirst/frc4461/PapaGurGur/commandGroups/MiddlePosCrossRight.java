package org.usfirst.frc4461.PapaGurGur.commandGroups;

import org.usfirst.frc4461.PapaGurGur.commands.EncoderDrive;
import org.usfirst.frc4461.PapaGurGur.commands.GyroTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MiddlePosCrossRight extends CommandGroup {

    public MiddlePosCrossRight() {
        addSequential(EncoderDrive.GoForward(50));
        addSequential(GyroTurn.turnRight(90));
        addSequential(EncoderDrive.GoForward(90));
        addSequential(GyroTurn.turnLeft(90));
        addSequential(EncoderDrive.GoForward(60));
    }
}
