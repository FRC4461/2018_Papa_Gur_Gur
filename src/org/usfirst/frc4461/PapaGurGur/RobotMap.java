package org.usfirst.frc4461.PapaGurGur;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class RobotMap {
    public static WPI_TalonSRX frontLeft;
    public static WPI_TalonSRX backLeft;
    
    public static WPI_TalonSRX frontRight;
    public static WPI_TalonSRX backRight;


    public static void init() {
    	frontLeft = new WPI_TalonSRX(1);
    	backLeft = new WPI_TalonSRX(2);
        
    	frontRight = new WPI_TalonSRX(3);
    	backRight = new WPI_TalonSRX(4);
          }
}
