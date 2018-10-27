package org.firstinspires.ftc.teamcode.encoderExampleAutonomous;

import org.firstinspires.ftc.teamcode.autonomous.State2;
import org.firstinspires.ftc.teamcode.stateMachine.DrivingState;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

public class Drive1Rotations extends DrivingState {
    // This number 288 came from: http://www.revrobotics.com/rev-41-1300/
    static final double COUNTS_PER_MOTOR = 240;

    public Drive1Rotations(StateMachine stateMachine) {
        super(stateMachine,
                State2.class,
                -0.5,
                .5);
    }

    @Override
    public void postEventsCallback() {
        super.postEventsCallback();

        addTelemetry("Left Motor Pos: ", "%d", leftDrive.getCurrentPosition());
        addTelemetry("Right Motor Pos: ", "%d", rightDrive.getCurrentPosition());

        if (leftDrive.getCurrentPosition() > COUNTS_PER_MOTOR) {
            stopMotors();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stateMachine.stop();
        }
    }
}
