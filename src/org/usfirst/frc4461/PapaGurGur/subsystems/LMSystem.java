package org.usfirst.frc4461.PapaGurGur.subsystems;

import org.usfirst.frc4461.PapaGurGur.commands.Elevator;

import edu.wpi.first.wpilibj.command.Subsystem;

public class LMSystem extends Subsystem {
	
	public LMSystem() {
	}

	@Override
	protected void initDefaultCommand() {	
		setDefaultCommand(new Elevator());
	}


	
}