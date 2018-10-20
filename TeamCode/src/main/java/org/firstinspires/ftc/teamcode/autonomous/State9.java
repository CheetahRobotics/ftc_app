package org.firstinspires.ftc.teamcode.autonomous;

import org.firstinspires.ftc.teamcode.stateMachine.DrivingState;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

public class State9 extends DrivingState {
    State9(StateMachine stateMachine) {
        super(stateMachine,
                2.5,
                State2.class,
                0.5,
                -.5);
    }
}
