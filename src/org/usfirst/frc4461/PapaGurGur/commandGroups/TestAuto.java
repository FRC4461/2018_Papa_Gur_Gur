package org.usfirst.frc4461.PapaGurGur.commandGroups;

import org.usfirst.frc4461.PapaGurGur.commands.AutonomousElevator;
import org.usfirst.frc4461.PapaGurGur.commands.CloseGripper;
import org.usfirst.frc4461.PapaGurGur.commands.Delay;
import org.usfirst.frc4461.PapaGurGur.commands.EncoderDrive;
import org.usfirst.frc4461.PapaGurGur.commands.GyroTurn;
import org.usfirst.frc4461.PapaGurGur.commands.OpenGripper;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TestAuto extends CommandGroup {

    public TestAuto() {
        addSequential(EncoderDrive.GoForward(40));
        addSequential(new Delay(1));
        addSequential(EncoderDrive.GoBackward(40));
        addParallel(AutonomousElevator.GoUp(50));
        addSequential(new Delay(2));
        addSequential(new OpenGripper(1));
        addSequential(new Delay(0.5));
        addParallel(AutonomousElevator.GoDown(0));
        addParallel(new CloseGripper(1));
        addSequential(EncoderDrive.GoBackward(40));
    }
}
