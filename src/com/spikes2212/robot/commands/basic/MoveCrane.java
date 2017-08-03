package com.spikes2212.robot.commands.basic;

import com.spikes2212.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class MoveCrane extends Command {

    private double speed;

    public MoveCrane(double speed) {
        requires(Robot.crane);

        this.speed = speed;
    }


    @Override
    protected void execute() {
        Robot.crane.tryMove(speed);
    }

    @Override
    protected void end() {
        Robot.crane.tryMove(0);
    }

    @Override
    protected void interrupted() {
        end();
    }

    @Override
    protected boolean isFinished() {
        return !Robot.crane.canMove(speed);
    }
}
