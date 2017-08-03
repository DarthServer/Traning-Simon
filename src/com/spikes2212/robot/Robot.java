package com.spikes2212.robot;


import com.ctre.CANTalon;
import com.spikes2212.robot.commands.autonomous.MoveCollectBallsAndShoot;
import com.spikes2212.robot.components.MotorGroup;
import com.spikes2212.robot.subsystems.Crane;
import com.spikes2212.robot.subsystems.Drivetrain;
import com.spikes2212.robot.subsystems.Feeder;
import com.spikes2212.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Scheduler;



public class Robot extends IterativeRobot {

    public static OI oi;


    public static Drivetrain drivetrain;
    public static Crane crane;
    public static Feeder feeder;
    public static Shooter shooter;


    private MoveCollectBallsAndShoot autonomousCommand;

    @Override
    public void robotInit() {


        // initializing the crane subsystem
        crane = new Crane(new VictorSP(RobotMap.PWM.CRAIN_MOTOR),
                new DigitalInput(RobotMap.DIO.CRAIN_UP_SWITCH), new DigitalInput(RobotMap.DIO.CRAIN_DOWN_SWITCH));

        shooter = new Shooter(new VictorSP(RobotMap.PWM.SHOOTER_MOTOR));

        feeder = new Feeder(new VictorSP(RobotMap.PWM.FEEDER_MOTOR));

        autonomousCommand = new MoveCollectBallsAndShoot();

        drivetrain = new Drivetrain(new MotorGroup(new CANTalon(RobotMap.CAN.LEFT_MOTOR_1),
                new CANTalon(RobotMap.CAN.LEFT_MOTOR_2)),
                new MotorGroup(new CANTalon(RobotMap.CAN.RIGHT_MOTOR_1),
                        new CANTalon(RobotMap.CAN.RIGHT_MOTOR_2)));

        oi = new OI();

    }

    @Override
    public void disabledInit() {

    }

    @Override
    public void autonomousInit() {
        autonomousCommand.start();
    }

    @Override
    public void autonomousPeriodic(){
        Scheduler.getInstance().run();
    }


    @Override
    public void teleopInit() {
        autonomousCommand.cancel();
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
}
