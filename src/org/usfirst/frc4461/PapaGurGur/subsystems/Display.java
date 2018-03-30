package org.usfirst.frc4461.PapaGurGur.subsystems;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Display extends Subsystem {

    SerialPort port = null;

    public Display() {
        try {
            port = new SerialPort(115200, SerialPort.Port.kUSB);
        } catch (Exception e) {

        }
    }

    enum LastVar {
        NONE, MUSHROOM, FACE
    }

    LastVar previous = LastVar.NONE;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void showMushroom() {
        if (previous != LastVar.MUSHROOM && port != null) {
            previous = LastVar.MUSHROOM;
            port.writeString("m");
        }
    }

    public void showFace() {
        if (previous != LastVar.FACE && port != null) {
            previous = LastVar.FACE;
            port.writeString("n");
        }
    }

    public void clear() {
        if (previous != LastVar.NONE && port != null) {
            previous = LastVar.NONE;
            port.writeString("c");
        }
    }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}
