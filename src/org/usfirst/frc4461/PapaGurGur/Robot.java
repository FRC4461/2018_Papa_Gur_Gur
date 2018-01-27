package org.usfirst.frc4461.PapaGurGur;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc4461.PapaGurGur.commands.LeftScale;
import org.usfirst.frc4461.PapaGurGur.commands.LeftSwitch;
import org.usfirst.frc4461.PapaGurGur.subsystems.*;

public class Robot extends IterativeRobot {
    Command autonomousCommand;
    public static OI oi;
    public static DriveBase driveBase;
    public static Display display;
    public static Gyro gyro;
    public static SPI.Port gyroAnalogInput = SPI.Port.kOnboardCS0;
    SendableChooser <Command> autoChooser;
    
    public void robotInit() {
    	RobotMap.init();
        driveBase = new DriveBase();
        display = new Display();
        oi = new OI();
        autoChooser = new SendableChooser<Command>();
        autoChooser.addObject("Left Switch", new LeftSwitch());
        autoChooser.addObject("Left Scale", new LeftScale());
        SmartDashboard.putData("Auto Routine", autoChooser);
    }

    public void disabledInit(){

    }


    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
    	autonomousCommand = (Command) autoChooser.getSelected();
        if (autonomousCommand != null) 
        	autonomousCommand.start();
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