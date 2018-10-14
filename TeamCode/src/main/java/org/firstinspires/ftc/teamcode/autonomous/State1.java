package org.firstinspires.ftc.teamcode.autonomous;

import org.firstinspires.ftc.teamcode.stateMachine.DrivingState;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

class State1 extends DrivingState {
    State1(StateMachine stateMachine) {
        super(stateMachine,
                2.,
                2,
                0.5,
                -.5);
    }
}
