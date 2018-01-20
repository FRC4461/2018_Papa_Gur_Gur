package org.usfirst.frc4461.PapaGurGur;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class RobotMap {
    public static WPI_TalonSRX left1;
    public static WPI_TalonSRX left2;
    
    public static WPI_TalonSRX right1;
    public static WPI_TalonSRX right2;


    public static void init() {
        left1 = new WPI_TalonSRX(1);
        left2 = new WPI_TalonSRX(2);
        
        right1 = new WPI_TalonSRX(3);
        right2 = new WPI_TalonSRX(4);
    }
}
