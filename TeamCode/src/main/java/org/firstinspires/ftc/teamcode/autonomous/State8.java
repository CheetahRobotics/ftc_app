package org.firstinspires.ftc.teamcode.autonomous;

import org.firstinspires.ftc.teamcode.stateMachine.DrivingState;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

public class State8 extends DrivingState {
    State8(StateMachine stateMachine) {
        super(stateMachine,
                2.,
                State9.class,
                0.5,
                0);
    }
}
