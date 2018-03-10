package org.usfirst.frc4461.PapaGurGur;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	// Controllers
	private static Joystick m_LJoy;
	private static Joystick m_RJoy;
	private static XboxController m_Xbox;

	// Left Joystick Buttons
	Button lButton1 = new JoystickButton(m_LJoy, 1);
	Button lButton2 = new JoystickButton(m_LJoy, 2);
	Button lButton3 = new JoystickButton(m_LJoy, 3);

	// Right Joystick Buttons
	Button rButton1 = new JoystickButton(m_RJoy, 1);
	Button rButton2 = new JoystickButton(m_RJoy, 2);
	Button rButton3 = new JoystickButton(m_RJoy, 3);

	public OI() {
		m_LJoy = new Joystick(0);
		m_RJoy = new Joystick(1);
		m_Xbox = new XboxController(2);
	}

	public static double lJoyGetY() {
		return m_LJoy.getY();
	}

	public static double rJoyGetY() {
		return m_RJoy.getY();
	}
}