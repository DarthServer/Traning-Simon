package com.spikes2212.robot.commands.autonomous;

import com.spikes2212.robot.commands.basic.CollectBalls;
import com.spikes2212.robot.commands.basic.DriveTank;
import com.spikes2212.robot.commands.basic.Shoot;
import com.spikes2212.robot.subsystems.Feeder;
import com.spikes2212.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveCollectBallsAndShoot extends CommandGroup {

    public MoveCollectBallsAndShoot() {
        addParallel(new CollectBalls(Feeder.FEEDER_SPEED), 10);
        addSequential(new DriveTank(1, 1), 10);
        addSequential(new Shoot(Shooter.SHOOTING_SPEED), 5);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
