package com.spikes2212.robot;

import com.spikes2212.robot.commands.basic.CollectBalls;
import com.spikes2212.robot.commands.basic.MoveCrane;
import com.spikes2212.robot.commands.basic.Shoot;
import com.spikes2212.robot.subsystems.Crane;
import com.spikes2212.robot.subsystems.Feeder;
import com.spikes2212.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI /* GEVALD */ {

    private Joystick leftJoystick;
    private Joystick rightJoystick;

    private JoystickButton moveCraneUpButton;
    private JoystickButton moveCraneDownButton;
    private JoystickButton shootButton;
    private JoystickButton collectBallsButton;

    public OI() {
        rightJoystick = new Joystick(RobotMap.JOYSTIC.RIGHT_JOYSTIC);
        leftJoystick = new Joystick(RobotMap.JOYSTIC.LEFT_JOYSTIC);

        moveCraneUpButton = new JoystickButton(rightJoystick, RobotMap.JOYSTIC.MOVE_CRANE_UP_BUTTON);
        moveCraneDownButton = new JoystickButton(rightJoystick, RobotMap.JOYSTIC.MOVE_CRANE_DOWN_BUTTON);


        shootButton = new JoystickButton(leftJoystick, RobotMap.JOYSTIC.SHOOT_BUTTON);
        collectBallsButton = new JoystickButton(leftJoystick, RobotMap.JOYSTIC.COLLECT_BALLS_BUTTON);

        initButtons();
    }

    private void initButtons() {
        moveCraneUpButton.whileHeld(new MoveCrane(Crane.CRANE_UP_SPEED));
        moveCraneDownButton.whileHeld(new MoveCrane(Crane.CRANE_DOWN_SPEED));

        shootButton.whileHeld(new Shoot(Shooter.SHOOTING_SPEED));
        collectBallsButton.whileHeld(new CollectBalls(Feeder.FEEDER_SPEED));
    }

    private static double adjust(double val) {
        return val * Math.abs(val);
    }
    public double getLeftY() {
        return adjust(leftJoystick.getY());
    }

    public double getRightY() {
        return adjust(rightJoystick.getY());
    }
}
