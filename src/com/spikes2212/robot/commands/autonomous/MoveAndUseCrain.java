package com.spikes2212.robot.commands.autonomous;

import com.spikes2212.robot.commands.basic.DriveTank;
import com.spikes2212.robot.commands.basic.MoveCrane;
import com.spikes2212.robot.subsystems.Crane;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class MoveAndUseCrain extends CommandGroup {

    public MoveAndUseCrain() {
        addSequential(new DriveTank(1,1), 5);
        addSequential(new MoveCrane(Crane.CRANE_UP_SPEED));
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
