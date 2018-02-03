package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;

/**
 *
 */
public class ScheduleCommands extends Command {

	String gameData;
	SendableChooser<Command> autoChooser = new SendableChooser<Command>();
	
    public ScheduleCommands(SendableChooser<Command> sendableChooser) {
    	autoChooser = sendableChooser;
    }

    protected void initialize() {
    	gameData = DriverStation.getInstance().getGameSpecificMessage();
    	if (gameData.charAt(0) == 'L') {
    		if(gameData.charAt(1) == 'L') {
        		autoChooser.getSelected().start();
    		} else {
    		}
    	} else {
    		
    	}
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
