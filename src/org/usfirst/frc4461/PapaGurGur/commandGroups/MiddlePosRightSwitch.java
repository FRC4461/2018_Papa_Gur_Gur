package org.usfirst.frc4461.PapaGurGur.commandGroups;

import org.usfirst.frc4461.PapaGurGur.commands.AutonomousElevator;
import org.usfirst.frc4461.PapaGurGur.commands.CloseGripper;
import org.usfirst.frc4461.PapaGurGur.commands.EncoderDrive;
import org.usfirst.frc4461.PapaGurGur.commands.GyroTurn;
import org.usfirst.frc4461.PapaGurGur.commands.OpenGripper;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MiddlePosRightSwitch extends CommandGroup {

    public MiddlePosRightSwitch() {
        addSequential(EncoderDrive.GoForward(30));
        addSequential(GyroTurn.turnRight(90));
        addSequential(EncoderDrive.GoForward(60));
        addSequential(GyroTurn.turnLeft(90));
        addParallel(AutonomousElevator.GoUp(45));
        addSequential(EncoderDrive.GoForward(110));
        addSequential(new OpenGripper());
    }
}
