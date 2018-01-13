package org.usfirst.frc4461.PapaGurGur.subsystems;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Display extends Subsystem {

	SerialPort port = new SerialPort(115200, SerialPort.Port.kUSB);

	enum LastVar {
		NONE, MUSHROOM, FACE
	}

	LastVar previous = LastVar.NONE;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void showMushroom() {
		if (previous != LastVar.MUSHROOM) {
			previous = LastVar.MUSHROOM;
			port.writeString("m");
		}
	}

	public void showFace() {
		if (previous != LastVar.FACE) {
			previous = LastVar.FACE;
			port.writeString("n");
		}
	}

	public void clear() {
		if (previous != LastVar.NONE) {
			previous = LastVar.NONE;
			port.writeString("c");
		}
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
