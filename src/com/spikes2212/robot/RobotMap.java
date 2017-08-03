package com.spikes2212.robot;

/*

*/

public class RobotMap {
    public static interface PWM {

        // crane motor
        public static final int CRAIN_MOTOR = 2;

        // feeder motor
        public static final int FEEDER_MOTOR = 6;

        // shooter

        public static final int SHOOTER_MOTOR = 7;
    }

    public static interface CAN {
        // driving system motors
        public static final int LEFT_MOTOR_1  = 4;
        public static final int RIGHT_MOTOR_1 = 6;
        public static final int LEFT_MOTOR_2 = 5;
        public static final int RIGHT_MOTOR_2 = 1;

    }

    public static interface DIO {
        public static final int CRAIN_DOWN_SWITCH = 2;
        public static final int CRAIN_UP_SWITCH = 6;
    }

    public static interface JOYSTIC {

        // joystic ports
        public static final int LEFT_JOYSTIC = 0;
        public static final int RIGHT_JOYSTIC = 1;

        // right joystick buttons
        public static final int MOVE_CRANE_UP_BUTTON   = 3;
        public static final int MOVE_CRANE_DOWN_BUTTON = 2;

        // left joystick buttons
        public static final int SHOOT_BUTTON = 1;
        public static final int COLLECT_BALLS_BUTTON = 2;
    }
}
