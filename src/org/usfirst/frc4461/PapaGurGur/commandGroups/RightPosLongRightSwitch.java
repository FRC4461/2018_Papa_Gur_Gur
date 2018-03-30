package org.usfirst.frc4461.PapaGurGur.commandGroups;

import org.usfirst.frc4461.PapaGurGur.commands.AutonomousElevator;
import org.usfirst.frc4461.PapaGurGur.commands.Delay;
import org.usfirst.frc4461.PapaGurGur.commands.EncoderDrive;
import org.usfirst.frc4461.PapaGurGur.commands.GyroTurn;
import org.usfirst.frc4461.PapaGurGur.commands.OpenGripper;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightPosLongRightSwitch extends CommandGroup {

    public RightPosLongRightSwitch() {
        addSequential(EncoderDrive.GoForward(150));
        addSequential(GyroTurn.turnLeft(90));
        // please check this xd
        addParallel(AutonomousElevator.GoUp(45));
        addSequential(EncoderDrive.GoForward(20));
        addSequential(new OpenGripper());
    }
}
