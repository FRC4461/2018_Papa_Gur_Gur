package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ScheduleCommands extends Command {
	/**
	 * Gets the game data from the FMS. We only care about the 2 values to
	 * determine our autonomous routine
	 */
	public ScheduleCommands() {
	}

	protected void initialize() {
		System.out.println("Call Scheduler");
		String gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		if (gameData.charAt(0) == 'L') {
			if (gameData.charAt(1) == 'L') {
				Robot.LL.getSelected().start();
			} else if (gameData.charAt(1) == 'R') {
				Robot.LR.getSelected().start();
			}
		} else if (gameData.charAt(0) == 'R') {
			if (gameData.charAt(1) == 'R') {
				Robot.RR.getSelected().start();
			} else if (gameData.charAt(1) == 'L') {
				Robot.RL.getSelected().start();
			}
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
