package org.usfirst.frc4461.PapaGurGur;

import org.usfirst.frc4461.PapaGurGur.commandGroups.CrossLine;
import org.usfirst.frc4461.PapaGurGur.commandGroups.RightPosRightScale;
import org.usfirst.frc4461.PapaGurGur.commandGroups.RightPosRightSwitch;
import org.usfirst.frc4461.PapaGurGur.commands.ScheduleCommands;
import org.usfirst.frc4461.PapaGurGur.subsystems.Display;
import org.usfirst.frc4461.PapaGurGur.subsystems.DriveBase;
import org.usfirst.frc4461.PapaGurGur.subsystems.Elevator;
import org.usfirst.frc4461.PapaGurGur.subsystems.Gripper;
import org.usfirst.frc4461.PapaGurGur.subsystems.Gyro;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
    Command autonomousCommand;
    public static OI oi;
    public static DriveBase driveBase;
    public static Display display;
    public static Encoder encoder;
    public static Elevator elevator;
    public static Gripper gripper;
    public static Gyro gyro;

    public static SPI.Port gyroAnalogInput = SPI.Port.kOnboardCS0;

    public static SendableChooser<Command> LL;
    public static SendableChooser<Command> LR;
    public static SendableChooser<Command> RR;
    public static SendableChooser<Command> RL;

    public void listChoosers(SendableChooser<Command> sendableChooser) {
	sendableChooser.addObject("RightPosRightScale", new RightPosRightScale());
	sendableChooser.addObject("RightPosRightSwitch", new RightPosRightSwitch());
	sendableChooser.addObject("CrossLine", new CrossLine());
    }

    @Override
    public void robotInit() {
	RobotMap.init();
	driveBase = new DriveBase();
	display = new Display();
	elevator = new Elevator();
	gripper = new Gripper();
	gyro = new Gyro();
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

    @Override
    public void disabledInit() {

    }

    @Override
    public void disabledPeriodic() {
	Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
	if (autonomousCommand != null) {
	    autonomousCommand.start();
	}
    }

    @Override
    public void autonomousPeriodic() {
	Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {

    }

    @Override
    public void teleopPeriodic() {
	Scheduler.getInstance().run();
    }

    @Override
    public void testPeriodic() {

    }
}