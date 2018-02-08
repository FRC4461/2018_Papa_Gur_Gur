package org.usfirst.frc4461.PapaGurGur;

import org.usfirst.frc4461.PapaGurGur.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
    public static Joystick lJoy = new Joystick(0);
    public static Joystick rJoy = new Joystick(1);
    
    Button button1 = new JoystickButton(lJoy, 1);
    Button button2 = new JoystickButton(lJoy, 2);

    public OI() {        
        button1.whileHeld(new ActivateSolenoid());
        button2.whileHeld(new ActivateCompressor());
        

        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
    }
    
    public static boolean lJoyTriggerDown(){
    	return lJoy.getTopPressed();
    }

    public static double lJoyGetY(){
    	return lJoy.getY();
    }

    public static double rJoyGetY() {
        return rJoy.getY();
    }
}