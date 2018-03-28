package org.usfirst.frc4461.PapaGurGur;

import org.usfirst.frc4461.PapaGurGur.commandGroups.CrossLine;
import org.usfirst.frc4461.PapaGurGur.commandGroups.DoNothing;
import org.usfirst.frc4461.PapaGurGur.commandGroups.LeftPosLeftScale;
import org.usfirst.frc4461.PapaGurGur.commandGroups.LeftPosLeftSwitch;
import org.usfirst.frc4461.PapaGurGur.commandGroups.LeftPosLongLeftSwitch;
import org.usfirst.frc4461.PapaGurGur.commandGroups.LeftPosRightSwitch;
import org.usfirst.frc4461.PapaGurGur.commandGroups.MiddlePosCrossLeft;
import org.usfirst.frc4461.PapaGurGur.commandGroups.MiddlePosCrossRight;
import org.usfirst.frc4461.PapaGurGur.commandGroups.MiddlePosLeftSwitch;
import org.usfirst.frc4461.PapaGurGur.commandGroups.MiddlePosRightSwitch;
import org.usfirst.frc4461.PapaGurGur.commandGroups.RightPosLeftSwitch;
import org.usfirst.frc4461.PapaGurGur.commandGroups.RightPosLongRightSwitch;
import org.usfirst.frc4461.PapaGurGur.commandGroups.RightPosRightScale;
import org.usfirst.frc4461.PapaGurGur.commandGroups.RightPosRightSwitch;
import org.usfirst.frc4461.PapaGurGur.commandGroups.TestAuto;
import org.usfirst.frc4461.PapaGurGur.commands.ScheduleCommands;
import org.usfirst.frc4461.PapaGurGur.subsystems.Display;
import org.usfirst.frc4461.PapaGurGur.subsystems.DriveBase;
import org.usfirst.frc4461.PapaGurGur.subsystems.Elevator;
import org.usfirst.frc4461.PapaGurGur.subsystems.GripMotors;
import org.usfirst.frc4461.PapaGurGur.subsystems.GripperPneumatics;
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
	public static GripperPneumatics gripPneumatics;
	public static Gyro gyro;
	public static GripMotors gripMotors;

	public static SPI.Port gyroAnalogInput = SPI.Port.kOnboardCS0;

	public static SendableChooser<Command> LL;
	public static SendableChooser<Command> LR;
	public static SendableChooser<Command> RR;
	public static SendableChooser<Command> RL;
	public static SendableChooser<Command> Nothing;

	public void listChoosers(SendableChooser<Command> sendableChooser) {
		// Right side auto routines
		sendableChooser.addObject("RightPosRightScale", new RightPosRightScale());
		sendableChooser.addObject("RightPosRightSwitch", new RightPosRightSwitch());
		sendableChooser.addObject("RightPosLeftSwitch", new RightPosLeftSwitch());
		sendableChooser.addObject("RightPosLongRightSwitch", new RightPosLongRightSwitch());

		// Left side auto routines
		sendableChooser.addObject("LeftPosLeftScale", new LeftPosLeftScale());
		sendableChooser.addObject("LeftPosLeftSwitch", new LeftPosLeftSwitch());
		sendableChooser.addObject("LeftPosRightSwitch", new LeftPosRightSwitch());
		sendableChooser.addObject("LeftPosLongLeftSwitch", new LeftPosLongLeftSwitch());

		// Middle position auto routines
		sendableChooser.addObject("MiddlePosCrossLeft", new MiddlePosCrossLeft());
		sendableChooser.addObject("MiddlePosCrossRight", new MiddlePosCrossRight());
		sendableChooser.addObject("MiddlePosLeftSwitch", new MiddlePosLeftSwitch());
		sendableChooser.addObject("MiddlePosRightSwitch", new MiddlePosRightSwitch());

		// default and nothingness
		sendableChooser.addObject("CrossLine", new CrossLine());
		sendableChooser.addObject("None", new DoNothing());

		sendableChooser.addDefault("None", new DoNothing());
		sendableChooser.addObject("Test Auto", new TestAuto());
	}

	@Override
	public void robotInit() {
		RobotMap.init();

		gripMotors = new GripMotors();
		driveBase = new DriveBase();
		display = new Display();
		elevator = new Elevator();
		gripPneumatics = new GripperPneumatics();
		gyro = new Gyro();
		oi = new OI();

		LL = new SendableChooser<Command>();
		LR = new SendableChooser<Command>();
		RR = new SendableChooser<Command>();
		RL = new SendableChooser<Command>();
		Nothing = new SendableChooser<Command>();

		SmartDashboard.putData("LL", LL);
		SmartDashboard.putData("LR", LR);
		SmartDashboard.putData("RR", RR);
		SmartDashboard.putData("RL", RL);
		SmartDashboard.putData("None", Nothing);

		listChoosers(LL);
		listChoosers(LR);
		listChoosers(RR);
		listChoosers(RL);

		Robot.gripPneumatics.turnOnCompressor();
		Robot.elevator.resetElevatorEncoder();

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
		Robot.gyro.resetGyro();
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