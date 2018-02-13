package org.usfirst.frc4461.PapaGurGur;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc4461.PapaGurGur.commands.LeftScale;
import org.usfirst.frc4461.PapaGurGur.commands.LeftSwitch;
import org.usfirst.frc4461.PapaGurGur.commands.RightScale;
import org.usfirst.frc4461.PapaGurGur.commands.RightSwitch;
import org.usfirst.frc4461.PapaGurGur.commands.ScheduleCommands;
import org.usfirst.frc4461.PapaGurGur.subsystems.*;

public class Robot extends IterativeRobot {
    Command autonomousCommand;
    public static OI oi;
    public static DriveBase driveBase;
    public static Display display;
    public static Encoder encoder;
    public static Gyro gyro;
    public static SPI.Port gyroAnalogInput = SPI.Port.kOnboardCS0;
    public static SendableChooser<Command> LL;
    public static SendableChooser<Command> LR;
    public static SendableChooser<Command> RR;
    public static SendableChooser<Command> RL;
    
    public void listChoosers(SendableChooser<Command> sendableChooser ) {
    	sendableChooser.addObject("Left Scale", new LeftScale());
        sendableChooser.addObject("Left Switch", new LeftSwitch());
        sendableChooser.addObject("Right Scale", new RightScale());
        sendableChooser.addObject("Right Switch", new RightSwitch());
    }
    
    public void robotInit() {
    	RobotMap.init();
        driveBase = new DriveBase();
        display = new Display();
        oi = new OI();
        LL = new SendableChooser<Command>();
        LR = new SendableChooser<Command>();
        RR = new SendableChooser<Command>();
        RL = new SendableChooser<Command>();
        SmartDashboard.putData("LL", LL);
        SmartDashboard.putData("LR", LR);
        SmartDashboard.putData("RR", RR);
        SmartDashboard.putData("RL", RL);
        listChoosers(LL);
        listChoosers(LR);
        listChoosers(RR);
        listChoosers(RL);
    	RobotMap.compressor.setClosedLoopControl(true);
    	autonomousCommand = new ScheduleCommands();
    }

    public void disabledInit(){

    }


    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
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