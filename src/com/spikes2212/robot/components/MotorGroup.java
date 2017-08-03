package com.spikes2212.robot.components;

import edu.wpi.first.wpilibj.SpeedController;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class is used to wrap a number of {@link SpeedController} as one
 *
 *
 */

public class MotorGroup implements SpeedController {

    /**
     * An {@link ArrayList} that stores {@link SpeedController} instances
     */
    private ArrayList<SpeedController> controllers;

    /**
     * constructs a new ${@link MotorGroup} object
     * that wraps a number of {@link SpeedController} objects as one
     *
     * @param controllers this parameter is an array of {@link SpeedController} objects
     *                    the argument is vararg for more comfortable use
     */
    public MotorGroup(SpeedController... controllers) {
        this.controllers = new ArrayList<>();
        this.controllers.addAll(Arrays.asList(controllers).subList(0, controllers.length - 1));
    }

    /**
     *
     * @return returns the speed of the speed controllers
     */

    @Override
    public double get() {
        if (controllers.size() == 0)
            return 0;
        return controllers.get(0).get();
    }

    /**
     *
     * @param speed the speed the motor has to move at
     */
    @Override
    public void set(double speed) {
        for (int i = 0; i < controllers.size()-1; i++) {
            controllers.get(i).set(speed);
        }
    }

    /**
     *
     * @param isInverted makes all the speed Controllers inverted
     */

    @Override
    public void setInverted(boolean isInverted) {
        for (int i = 0; i < controllers.size()-1; i++) {
            controllers.get(i).setInverted(isInverted);
        }
    }

    /**
     *
     * @return returns isInverted field of all the speed controllers
     */
    @Override
    public boolean getInverted() {
        if (controllers.size() == 0) return false;
        return controllers.get(0).getInverted();
    }

    /**
     * disables all the speed controllers
     */
    @Override
    public void disable() {
        for (int i = 0; i < controllers.size()-1; i++) {
            controllers.get(i).disable();
        }
    }


    /**
     * stops the speed controllers
     */
    @Override
    public void stopMotor() {
        for (int i = 0; i < controllers.size()-1; i++) {
            controllers.get(i).stopMotor();
        }
    }


    /**
     * Set the output to the value calculated by PIDController for all the speed controllers
     *
     * @param output the value calculated by PIDController
     */
    @Override
    public void pidWrite(double output) {
        for (int i = 0; i < controllers.size()-1; i++) {
            controllers.get(i).pidWrite(output);
        }
    }
}
