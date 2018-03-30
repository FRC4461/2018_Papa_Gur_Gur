package org.usfirst.frc4461.PapaGurGur.commandGroups;

import org.usfirst.frc4461.PapaGurGur.commands.AutonomousElevator;
import org.usfirst.frc4461.PapaGurGur.commands.CloseGripper;
import org.usfirst.frc4461.PapaGurGur.commands.Delay;
import org.usfirst.frc4461.PapaGurGur.commands.EncoderDrive;
import org.usfirst.frc4461.PapaGurGur.commands.GyroTurn;
import org.usfirst.frc4461.PapaGurGur.commands.OpenGripper;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * This Command group will allow for you to go to the LEFT_SCALE when your robot
 * is positioned on the left.
 */
public class LeftPosLeftScale extends CommandGroup {

    public LeftPosLeftScale() {
        addSequential(EncoderDrive.GoForward(264));
        addParallel(AutonomousElevator.GoUp(101));
        addSequential(GyroTurn.turnRight(45));
        addSequential(EncoderDrive.GoBackward(58));
        addSequential(new Delay(1.5));
        addSequential(new OpenGripper());
        addSequential(EncoderDrive.GoBackward(40));
        addParallel(new CloseGripper());
        addSequential(AutonomousElevator.GoDown(0));
    }
}