package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.teamcode.stateMachine.StateBase;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

public class State1 extends StateBase {
    private final DcMotor leftDrive;
    State1(StateMachine stateMachine) {
        super(stateMachine);
        leftDrive  = hardwareMap.get(DcMotor.class, "motor_1");
    }

    @Override
    public void dpadUpChanged(boolean dpad_up) {
        if (dpad_up) {
            stateMachine.updateState(2);
            leftDrive.setPower(0.0);
        }
    }

    @Override
    public void dpadDownChanged(boolean dpad_down) {
        if (dpad_down) {
            stateMachine.updateState(3);
            leftDrive.setPower(0.0);
        }
    }

    @Override
    public void dpadLeftChanged(boolean dpad_left) {
        if (dpad_left) {
            leftDrive.setDirection(DcMotor.Direction.FORWARD);
            leftDrive.setPower(0.5);
            addTelemetry("Motor", "Driving forward");
        }
    }

    @Override
    public void dpadRightChanged(boolean dpad_right) {
        if (dpad_right) {
            leftDrive.setDirection(DcMotor.Direction.REVERSE);
            leftDrive.setPower(0.5);
            addTelemetry("Motor", "Driving backwards");
        }
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

        // this is called after all events
        addTelemetry("LeftStick", "X: %f, Y: %f",
                gamepad.left_stick_x, gamepad.left_stick_y);
    }
}
