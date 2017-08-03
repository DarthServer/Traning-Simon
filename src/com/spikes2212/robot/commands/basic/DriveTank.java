package com.spikes2212.robot.commands.basic;

import com.spikes2212.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

import java.util.function.Supplier;

public class DriveTank extends Command {


    private Supplier<Double> leftSpeedSupplier;
    private Supplier<Double> rightSpeedSupplier;

    public DriveTank (double leftSpeed, double rightSpeed) {
        this(() -> leftSpeed, () -> rightSpeed);
    }

    public DriveTank(Supplier<Double> leftSpeedSupplier, Supplier<Double> rightSpeedSupplier) {
        requires(Robot.drivetrain);
        this.leftSpeedSupplier = leftSpeedSupplier;
        this.rightSpeedSupplier = rightSpeedSupplier;
    }

    @Override
    protected void initialize() {}

    @Override
    protected void execute() {

        Robot.drivetrain.driveTank(leftSpeedSupplier.get(), rightSpeedSupplier.get());
    }

    @Override
    protected void end() {

        Robot.drivetrain.driveTank(0,0);
    }

    @Override
    protected void interrupted() {
        end();
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }
}
