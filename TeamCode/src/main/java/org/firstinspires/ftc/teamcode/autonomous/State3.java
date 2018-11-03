package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.stateMachine.DrivingState;
import org.firstinspires.ftc.teamcode.stateMachine.StateBase;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

public class State3 extends DrivingState {
    static final double COUNTS_PER_MOTOR = 240;

    public State3(StateMachine stateMachine) {
        super(stateMachine,
                PlaceFlag.class,
                -0.5,
                .5);
    }

    @Override
    public void postEventsCallback() {
        super.postEventsCallback();

        addTelemetry("Left Motor Pos: ", "%d", leftDrive.getCurrentPosition());
        addTelemetry("Right Motor Pos: ", "%d", rightDrive.getCurrentPosition());


        if (Math.abs(leftDrive.getCurrentPosition()) > stateMachine.getRobotCalibration().getCounts(27.0)||
            Math.abs(rightDrive.getCurrentPosition()) > stateMachine.getRobotCalibration().getCounts(27.0)) {

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
    }
}

