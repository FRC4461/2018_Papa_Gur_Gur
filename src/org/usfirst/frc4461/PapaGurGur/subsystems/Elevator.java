package org.usfirst.frc4461.PapaGurGur.subsystems;

import org.usfirst.frc4461.PapaGurGur.RobotMap;
import org.usfirst.frc4461.PapaGurGur.commands.OperateElevator;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem {

    public Elevator() {
    }

    @Override
    protected void initDefaultCommand() {
	setDefaultCommand(new OperateElevator());
    }

    public void elevatorGoUp(double elevateSpeed) {
	RobotMap.elevatorMotor.set(elevateSpeed);
    }

    public void elevatorGoDown(double elevateSpeed) {
	RobotMap.elevatorMotor.set(-elevateSpeed);
    }

    public void stopElevator() {
	RobotMap.elevatorMotor.set(0);
    }

}