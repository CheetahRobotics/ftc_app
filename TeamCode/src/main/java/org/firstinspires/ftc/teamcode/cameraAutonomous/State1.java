package org.firstinspires.ftc.teamcode.cameraAutonomous;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.teamcode.stateMachine.StateBase;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

public class State1 extends StateBase {
    public State1(StateMachine stateMachine) {
        super(stateMachine);
    }

    @Override
    public void timeUpdate(double sinceOpModePlay, double sinceStateStart) {
        OpMode opmode = (OpMode) stateMachine.opMode();

        addTelemetry("H Value", "%f", opmode.getH());
    }

    @Override
    public void dpadUpChanged(boolean dpad_up) {
        if (dpad_up) {
            OpMode opmode = (OpMode) stateMachine.opMode();
            opmode.incrementView();
        }
    }
    @Override
    public void dpadRightChanged(boolean dpad_right) {
        if (dpad_right) {
            OpMode opmode = (OpMode) stateMachine.opMode();
            opmode.incrementH();
        }
    }

    @Override
    public void dpadLeftChanged(boolean dpad_left) {
        if (dpad_left) {
            OpMode opmode = (OpMode) stateMachine.opMode();
            opmode.decrementH();
        }
    }

    @Override
    public void postEventsCallback() {
        OpMode opmode = (OpMode) stateMachine.opMode();
        addTelemetry("Blob Center", "%f, %f",
                opmode.getCenterOfBiggestBlob().x,
                opmode.getCenterOfBiggestBlob().y);
    }
}
