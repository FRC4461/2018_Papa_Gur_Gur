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
		distanceInTicks = distance / .00306641;
		//Robot.driveBase.encoderMove(distanceInTicks);
	}

	@Override
	protected void execute() {
		gyroTurning.nintit();
	}

<<<<<<< HEAD
    protected void execute() {
    	double currentAngle = Robot.gyro.getAngle();
    	System.out.println(currentAngle);
    }
=======
	//@Override
	//protected boolean isFinished(){
		//double ticksToTarget = distanceInTicks - Robot.driveBase.leftEncoderGet();
		//if(Math.abs(ticksToTarget) < 50){
		//return true;
		//}
		//else return false;
	//}
>>>>>>> c25bb8a96cbb123cd2d883489d55d4a1222cee9c

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