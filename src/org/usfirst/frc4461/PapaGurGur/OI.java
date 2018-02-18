package org.usfirst.frc4461.PapaGurGur;

import org.usfirst.frc4461.PapaGurGur.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	public static Joystick lJoy = new Joystick(0);
	public static Joystick rJoy = new Joystick(1);
	public static XboxController xBox = new XboxController(2);

	Button lButton1 = new JoystickButton(lJoy, 1);
	Button lButton2 = new JoystickButton(lJoy, 2);
	Button rButton1 = new JoystickButton(rJoy, 1);
	Button rButton2 = new JoystickButton(rJoy, 2);

	public OI() {
		rButton2.whileHeld(new PrepareToGrabCube());
		rButton2.whenReleased(new GrabCube());
	}

	public static double getRightXboxTriggerAxis() {
		return xBox.getTriggerAxis(Hand.kRight);
	}

	public static double getLeftXboxTriggerAxis() {
		return xBox.getTriggerAxis(Hand.kLeft);
	}

	public static boolean lJoyTriggerDown() {
		return lJoy.getTopPressed();
	}

	public static double lJoyGetY() {
		return lJoy.getY();
	}

	public static double rJoyGetY() {
		return rJoy.getY();
	}
}