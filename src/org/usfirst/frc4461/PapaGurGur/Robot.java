package org.usfirst.frc4461.PapaGurGur;

import edu.wpi.cscore.UsbCamera;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import org.usfirst.frc4461.PapaGurGur.commands.*;
import org.usfirst.frc4461.PapaGurGur.subsystems.*;

public class Robot extends IterativeRobot {
    Command autonomousCommand;
    public static OI oi;
    public static DriveBase driveBase;
    public static Display display;
    
    public void robotInit() {
    	RobotMap.init();
        driveBase = new DriveBase();
        oi = new OI();

        display = new Display();

        autonomousCommand = new AutonomousCommand();


    	CameraServer.getInstance().startAutomaticCapture(0);
    }

    public void disabledInit(){

    }


    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    public void testPeriodic() {

    }
}