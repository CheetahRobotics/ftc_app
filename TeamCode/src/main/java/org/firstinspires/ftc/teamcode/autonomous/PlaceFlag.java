package org.firstinspires.ftc.teamcode.autonomous;

import org.firstinspires.ftc.teamcode.stateMachine.DrivingState;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

public class PlaceFlag extends DrivingState {
    static final double COUNTS_PER_MOTOR = 240;

    public PlaceFlag(StateMachine stateMachine) {
        super(stateMachine,
                Stop.class,
                0.5,
                -.5);
        // placing the flag
    }

    @Override
    public void postEventsCallback() {
        super.postEventsCallback();

        addTelemetry("Left Motor Pos: ", "%d", leftDrive.getCurrentPosition());
        addTelemetry("Right Motor Pos: ", "%d", rightDrive.getCurrentPosition());

        if (Math.abs(leftDrive.getCurrentPosition()) > stateMachine.getRobotCalibration().getCounts(85.0) ||
            Math.abs(rightDrive.getCurrentPosition()) > stateMachine.getRobotCalibration().getCounts(85.0)) {

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
    }
}

