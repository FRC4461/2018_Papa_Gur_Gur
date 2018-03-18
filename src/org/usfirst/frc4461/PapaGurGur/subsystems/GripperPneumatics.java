package org.usfirst.frc4461.PapaGurGur.subsystems;

import org.usfirst.frc4461.PapaGurGur.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GripperPneumatics extends Subsystem {

    public GripperPneumatics() {
    }

    @Override
    protected void initDefaultCommand() {
    }

    public void openGripper() {
	RobotMap.doubleSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void closeGripper() {
	RobotMap.doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
}
