package org.usfirst.frc4461.PapaGurGur.commandGroups;

import org.usfirst.frc4461.PapaGurGur.commands.Delay;
import org.usfirst.frc4461.PapaGurGur.commands.EncoderDrive;
import org.usfirst.frc4461.PapaGurGur.commands.GyroTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TestAuto extends CommandGroup {

    public TestAuto() {
        addSequential(EncoderDrive.GoForward(40));
        //addSequential(new Delay(1));
        addSequential(EncoderDrive.GoBackward(40));
    }
}
