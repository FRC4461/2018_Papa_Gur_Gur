package org.usfirst.frc4461.PapaGurGur.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftScale extends CommandGroup {

    public LeftScale() {
    	addSequential(new GyroTurn(360));
    	addSequential(new EncoderDriveForward(10));
    }
}
