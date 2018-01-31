package org.usfirst.frc4461.PapaGurGur;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;

public class RobotMap {
    public static WPI_TalonSRX frontLeft;
    public static WPI_TalonSRX backLeft;
    public static WPI_TalonSRX frontRight;
    public static WPI_TalonSRX backRight;

	public static ADXRS450_Gyro gyro;
	public static Encoder encoder; 

    public static void init() {
    	//Drivebase Motors
    	frontLeft = new WPI_TalonSRX(1);
    	backLeft = new WPI_TalonSRX(2);
    	frontRight = new WPI_TalonSRX(3);
    	backRight = new WPI_TalonSRX(4);
    	
    	//Gyro
        gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);
    }
}