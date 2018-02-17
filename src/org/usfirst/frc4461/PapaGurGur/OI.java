package org.usfirst.frc4461.PapaGurGur;

import org.usfirst.frc4461.PapaGurGur.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
    public static Joystick lJoy = new Joystick(0);
    public static Joystick rJoy = new Joystick(1);
    
    Button lButton1 = new JoystickButton(lJoy, 1);
    Button lButton2 = new JoystickButton(lJoy, 2);
    Button rButton1 = new JoystickButton(rJoy, 1);
    Button rButton2 = new JoystickButton(rJoy, 2);

    public OI() {        
        lButton1.whileHeld(new ElevatorMove(ElevatorMove.Direction.UP));
        rButton1.whileHeld(new ElevatorMove(ElevatorMove.Direction.DOWN));
        rButton2.whileHeld(new PrepareToGrabCube());
        rButton2.whenReleased(new GrabCube());

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