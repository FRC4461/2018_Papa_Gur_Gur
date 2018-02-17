package org.usfirst.frc4461.PapaGurGur.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LeftSwitch extends CommandGroup {

    public LeftSwitch() {
        addSequential(GyroTurn.turnLeft(90));
    }
}
