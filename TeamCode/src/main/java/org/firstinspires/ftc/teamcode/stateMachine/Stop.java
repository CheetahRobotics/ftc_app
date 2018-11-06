package org.firstinspires.ftc.teamcode.stateMachine;

public class Stop  extends DrivingState {
    public  Stop (StateMachine stateMachine) {
        super(stateMachine,
                0.0,
                1.0,    // doesn't matter.
                Stop.class,
                0,
                0);

        stopMotors();
        sleep(1000);
        stateMachine.stop();
    }
}