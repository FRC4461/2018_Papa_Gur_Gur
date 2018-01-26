package org.usfirst.frc4461.PapaGurGur;

import org.usfirst.frc4461.PapaGurGur.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;

public class OI {
    public static Joystick lJoy;
    public static Joystick rJoy;

    public OI() {
        rJoy = new Joystick(1);
        lJoy = new Joystick(0);

        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
    }

    public static double lJoyGetY(){
    	double lSpeed = lJoy.getY();
    	return lSpeed;
    }

    public static double rJoyGetY() {
        double rSpeed = rJoy.getY();
        return rSpeed;
    }

}