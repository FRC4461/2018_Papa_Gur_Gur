package org.usfirst.frc4461.PapaGurGur.commandGroups;

import org.usfirst.frc4461.PapaGurGur.commands.AutonomousElevator;
import org.usfirst.frc4461.PapaGurGur.commands.EncoderDrive;
import org.usfirst.frc4461.PapaGurGur.commands.GyroTurn;
import org.usfirst.frc4461.PapaGurGur.commands.OpenGripper;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftPosRightSwitch extends CommandGroup {

    public LeftPosRightSwitch() {
        addSequential(EncoderDrive.GoForward(40));
        addSequential(GyroTurn.turnRight(90));
        addSequential(EncoderDrive.GoForward(140));
        addSequential(GyroTurn.turnLeft(90));
        addParallel(AutonomousElevator.GoUp(45));
        addSequential(EncoderDrive.GoForward(53));
        addSequential(new OpenGripper(2));
        addSequential(EncoderDrive.GoBackward(50));
        addParallel(AutonomousElevator.GoDown(0));
        addSequential(GyroTurn.turnRight(90));
        addSequential(EncoderDrive.GoForward(50));
        addSequential(GyroTurn.turnLeft(90));
        addSequential(EncoderDrive.GoForward(50));
    }
}
