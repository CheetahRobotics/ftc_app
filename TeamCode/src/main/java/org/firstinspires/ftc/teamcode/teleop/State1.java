package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.stateMachine.StateBase;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

public class State1 extends StateBase {
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive ;
    private DcMotor rightDrive ;
    private DcMotor arm;

    public State1(StateMachine stateMachine) {
        super(stateMachine);
        leftDrive  = hardwareMap.get(DcMotor.class, "motor_1");
        rightDrive = hardwareMap.get(DcMotor.class, "motor_2");
        arm = hardwareMap.get(DcMotor.class,"motor_3");
    }


    @Override
    public void timeUpdate(double sinceOpModePlay, double sinceStateStart) {
        addTelemetry("Time", "%f %f", sinceOpModePlay, sinceStateStart);
    }

    @Override
    public void touchSensorCallback(String key, TouchSensor touchSensor) {
        addTelemetry(key, "%f", touchSensor.getValue());
    }

    @Override
    public void postEventsCallback() {

        double leftPower;
        double rightPower;
        double liftpower;
        double droppower;

        double drive = -gamepad.right_stick_x;
        double turn  = gamepad.left_stick_y;
        float lift = gamepad.left_trigger;
        float drop = gamepad.right_trigger;

        leftPower   = Range.clip(drive + turn, -1.0, 1.0) ;
        rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;
        liftpower = Range.clip(lift,-1.0,1.0);
        droppower = Range.clip(drop,-1.0,1.0);

        leftDrive.setPower(leftPower);
        rightDrive.setPower(rightPower);
        arm.setPower(liftpower);
        arm.setPower(droppower);

        // this is called after all events
        addTelemetry("LeftStick", "X: %f, Y: %f",
                gamepad.left_stick_x, gamepad.left_stick_y);
        addTelemetry("Arm", "Lift: %f, Drop: %f",
                gamepad.left_trigger, gamepad.right_trigger);
        addTelemetry("Power", " Drive: %f, Turn: %f ",
                leftPower, rightPower);
    }
}

