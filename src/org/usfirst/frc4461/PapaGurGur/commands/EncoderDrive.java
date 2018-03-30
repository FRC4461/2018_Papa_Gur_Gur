package org.usfirst.frc4461.PapaGurGur.commands;

import org.usfirst.frc4461.PapaGurGur.Robot;
import org.usfirst.frc4461.PapaGurGur.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command for driving the robot to an exact position through encoder counts.
 */
public class EncoderDrive extends Command {

    private static final int    COUNTS_PER_REVOLUTION       = 512;
    private static final double GEAR_REDUCTION              = (45.0 / 19.0) * (50.0 / 14.0);
    private static final double COUNTS_PER_WHEEL_REVOLUTION = COUNTS_PER_REVOLUTION * GEAR_REDUCTION;
    private static final double WHEEL_CIRCUMFERENCE         = 6 * Math.PI;
    private static final double COUNTS_PER_INCH             = 190;                                   // COUNTS_PER_WHEEL_REVOLUTION
                                                                                                     // WHEEL_CIRCUMFERENCE;

    private final static double RAMP_SPEED                  = 2;
    private final static double MOTOR_SPEED                 = 0.5;

    private static double       directionMultiplier;

    private static final int    DEFAULT_TIMEOUT             = 3;

    private final int           countsToMove;

    private boolean             isDone                      = false;

    private static final double DRIVING_MULTIPLIER          = 1.3;

    /**
     * Drives forward based on inches.
     *
     * @param inchesToMove
     *            The number of inches to move. Setting a negative value will
     *            drive backwards.
     */

    private EncoderDrive(double inchesToMove) {
        requires(Robot.driveBase);
        countsToMove = (int) (COUNTS_PER_INCH * inchesToMove);
    }

    public static EncoderDrive GoForward(double inchesToMove) {
        System.out.println("Go Forward");
        directionMultiplier = 1;
        return new EncoderDrive(inchesToMove);
    }

    public static EncoderDrive GoBackward(double inchesToMove) {
        System.out.println("Go Backward");
        directionMultiplier = -1;
        return new EncoderDrive(inchesToMove);
    }

    @Override
    protected void initialize() {
        Robot.driveBase.configEncoder();
        Robot.gyro.resetGyro();
        System.out.println("am start");
    }

    @Override
    protected void execute() {
        int leftEncoder = RobotMap.frontLeft.getSelectedSensorPosition(0);
        int rightEncoder = RobotMap.frontRight.getSelectedSensorPosition(0);
        double gyroAngle = Robot.gyro.getAngle();

        System.out.println(
                "Left: " + " " + leftEncoder + "Right: " + rightEncoder + " " + "Counts To Move: " + countsToMove);

        // Gyro Angle
        System.out.println(gyroAngle);
        if (gyroAngle > -1 && gyroAngle < 1) {
            Robot.driveBase.drive(MOTOR_SPEED * directionMultiplier, MOTOR_SPEED * directionMultiplier);
        } else if (gyroAngle < -1) {
            System.out.println("Go left FASTER");
            Robot.driveBase.drive(MOTOR_SPEED * directionMultiplier * DRIVING_MULTIPLIER,
                    MOTOR_SPEED * directionMultiplier);
        } else if (gyroAngle > 1) {
            System.out.println("Go right FASTER");
            Robot.driveBase.drive(MOTOR_SPEED * directionMultiplier,
                    MOTOR_SPEED * directionMultiplier * DRIVING_MULTIPLIER);
        }
        if (Math.abs(leftEncoder) >= countsToMove && Math.abs(rightEncoder) >= countsToMove) {
            Robot.driveBase.stopMotors();
            isDone = true;
            System.out.println("STOP");
        }
    }

    @Override
    protected boolean isFinished() {
        return isDone;// || isTimedOut();
    }

    @Override
    protected void end() {
        Robot.driveBase.resetMotors();
    }

    @Override
    protected void interrupted() {
        end();
    }
}