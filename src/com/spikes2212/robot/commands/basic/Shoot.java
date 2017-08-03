package com.spikes2212.robot.commands.basic;

import com.spikes2212.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command {

    private double speed;

    public Shoot(double speed) {
        requires(Robot.shooter);
        this.speed = speed;

    }

    public Shoot(double speed, double timeout) {
        this(speed);

        setTimeout(timeout);
    }

    @Override
    protected void execute() {
        Robot.shooter.shoot(speed);
    }

    @Override
    protected void end() {
        Robot.shooter.shoot(0);
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
