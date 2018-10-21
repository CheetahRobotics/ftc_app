package org.firstinspires.ftc.teamcode.autonomous;

import org.firstinspires.ftc.teamcode.stateMachine.DrivingState;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

public class State7 extends DrivingState {
    State7(StateMachine stateMachine) {
        super(stateMachine,
                1.,
                State8.class,
                0.5,
                -.5);
    }
}

