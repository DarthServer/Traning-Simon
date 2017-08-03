package com.spikes2212.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Feeder extends Subsystem {


    public static final double FEEDER_SPEED = 0.3;

    private SpeedController motor;

    public Feeder(SpeedController motor) {
        this.motor = motor;
    }

    public void feed(double speed) {
        motor.set(speed);
    }

    @Override
    protected void initDefaultCommand() {

    }
}
