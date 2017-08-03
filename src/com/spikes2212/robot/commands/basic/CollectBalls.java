package com.spikes2212.robot.commands.basic;

import com.spikes2212.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class CollectBalls extends Command {



    private double speed;

    public CollectBalls(double speed) {
        requires(Robot.feeder);

        this.speed = speed;
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        Robot.feeder.feed(speed);
    }



    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }
}
