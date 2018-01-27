package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousCommand extends Command {
	double distance = 0;
	double distanceInTicks = 0;
	
	GyroTurning gyroTurning;
	
	/**
	 * @param timeRunArg how long it will run in milliseconds
	 */
	public void AutonomousMove(double distanceArg){
		requires(Robot.driveBase);
		distance = distanceArg;
	}

	@Override
	protected void initialize() {

	}

    protected void execute() {
    	double currentAngle = Robot.gyro.getAngle();
    	System.out.println(currentAngle);
    }

	@Override
	protected void end() {
		//Robot.driveBase.Stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}