package org.firstinspires.ftc.teamcode.autonomous;

import org.firstinspires.ftc.teamcode.stateMachine.DrivingState;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

public class State1 extends DrivingState {
    static final double COUNTS_PER_MOTOR = 240;

    public State1(StateMachine stateMachine) {
        super(stateMachine,
                State2.class,
                -0.5,
                .5);
        // after droping drives forward
    }
    @Override
    public void postEventsCallback() {
        super.postEventsCallback();

        addTelemetry("Left Motor Pos: ", "%d", leftDrive.getCurrentPosition());
        addTelemetry("Right Motor Pos: ", "%d", rightDrive.getCurrentPosition());

        if (leftDrive.getCurrentPosition() >
                stateMachine.getRobotCalibration().getCounts(45.0)) {
            if (Math.abs(leftDrive.getCurrentPosition()) > 440.64 ||
                    Math.abs(rightDrive.getCurrentPosition()) > 440.64) {
                addTelemetry("Left Motor Pos: ", "%d", leftDrive.getCurrentPosition());
                addTelemetry("Right Motor Pos: ", "%d", rightDrive.getCurrentPosition());
                stopMotors();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                stateMachine.updateState(this.nextState);
            }
            addTelemetry("Left Motor Pos: ", "%d", leftDrive.getCurrentPosition());
            addTelemetry("Right Motor Pos: ", "%d", rightDrive.getCurrentPosition());
            stopMotors();
            stateMachine.updateState(State2.class);
        }
    }
}

