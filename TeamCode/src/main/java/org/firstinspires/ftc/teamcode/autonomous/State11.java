package org.firstinspires.ftc.teamcode.autonomous;

import org.firstinspires.ftc.teamcode.stateMachine.DrivingState;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

public class State11 extends DrivingState {
    State11(StateMachine stateMachine) {
        super(stateMachine,
                5.,
                State2.class,
                -0.5,
                .5);
    }
}
