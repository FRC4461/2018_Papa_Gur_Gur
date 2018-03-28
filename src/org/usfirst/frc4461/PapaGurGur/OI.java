package org.usfirst.frc4461.PapaGurGur;

import org.usfirst.frc4461.PapaGurGur.commands.TeleopCloseGripper;
import org.usfirst.frc4461.PapaGurGur.commands.TeleopOpenGripper;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	// Controllers
	private static Joystick m_LJoy = new Joystick(0);
	private static Joystick m_RJoy = new Joystick(1);
	private static XboxController m_Xbox = new XboxController(2);

	// Left Joystick Buttons
	public static Button lButton1 = new JoystickButton(m_LJoy, 1);
	public static Button lButton2 = new JoystickButton(m_LJoy, 2);
	public static Button lButton3 = new JoystickButton(m_LJoy, 3);

	// Right Joystick Buttons
	public static Button rButton1 = new JoystickButton(m_RJoy, 1);
	public static Button rButton2 = new JoystickButton(m_RJoy, 2);
	public static Button rButton3 = new JoystickButton(m_RJoy, 3);

	public OI() {
		rButton1.toggleWhenPressed(new TeleopCloseGripper());
		lButton1.toggleWhenPressed(new TeleopOpenGripper());
	}

	public static double lJoyGetY() {
		return m_LJoy.getY();
	}

	public static double rJoyGetY() {
		return m_RJoy.getY();
	}

	public static boolean getRightBumper() {
		return m_Xbox.getBumper(Hand.kRight);
	}

	public static boolean getLeftBumper() {
		return m_Xbox.getBumper(Hand.kLeft);
	}

	public static boolean isAButtonPressed() {
		return m_Xbox.getAButton();
	}

	public static boolean isBButtonPressed() {
		return m_Xbox.getBButton();
	}

	public static double rightXboxTrigger() {
		return m_Xbox.getTriggerAxis(Hand.kRight);
	}

	public static double leftXboxTrigger() {
		return m_Xbox.getTriggerAxis(Hand.kLeft);
	}

	public static double leftXboxStick() {
		return m_Xbox.getY(Hand.kLeft);
	}

	public static double rightXboxStick() {
		return m_Xbox.getY(Hand.kRight);
	}
}