package org.usfirst.frc4461.PapaGurGur;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SPI;

public class RobotMap {
	// Drivebase
	public static WPI_TalonSRX frontLeft;
	public static WPI_TalonSRX backLeft;
	public static WPI_TalonSRX frontRight;
	public static WPI_TalonSRX backRight;

	// Elevator
	public static WPI_TalonSRX elevatorMotor;

	// Gripper
	public static WPI_TalonSRX gripMotor1;
	public static WPI_TalonSRX gripMotor2;

	// Gyro
	public static ADXRS450_Gyro gyro;

	// Compressor
	public static Compressor compressor;

	// Solenoid
	public static DoubleSolenoid doubleSolenoid;

	public static void init() {
		// Drivebase Motors
		backRight = new WPI_TalonSRX(1);
		backLeft = new WPI_TalonSRX(2);
		frontRight = new WPI_TalonSRX(3);
		frontLeft = new WPI_TalonSRX(4);

		// Elevator Motors
		elevatorMotor = new WPI_TalonSRX(5);

		// Gripper Motors
		gripMotor1 = new WPI_TalonSRX(6);
		gripMotor2 = new WPI_TalonSRX(7);

		// Gyro
		gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);

		// Pneumatics Compressor
		compressor = new Compressor(0);

		// Solenoid
		doubleSolenoid = new DoubleSolenoid(0, 1);
	}
}