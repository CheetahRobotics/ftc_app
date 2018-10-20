package org.firstinspires.ftc.teamcode.autonomous;

import org.firstinspires.ftc.teamcode.stateMachine.DrivingState;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

public class State6 extends DrivingState {
    State6(StateMachine stateMachine) {
        super(stateMachine,
                2.,
                State7.class,
                0,
                -.5);
    }
}
