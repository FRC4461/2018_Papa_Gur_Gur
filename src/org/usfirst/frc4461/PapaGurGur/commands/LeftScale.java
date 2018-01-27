package org.usfirst.frc4461.PapaGurGur.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftScale extends CommandGroup {

    public LeftScale() {
        addSequential(new GyroTurn(90));

        

        // To run multiple commands at the same time,
        // use addParallel()
    }
}
