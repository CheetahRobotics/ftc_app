package org.firstinspires.ftc.teamcode.autonomous;

import org.firstinspires.ftc.teamcode.stateMachine.DrivingState;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;
import org.firstinspires.ftc.teamcode.stateMachine.Stop;

public class State6 extends DrivingState {

    public State6(StateMachine stateMachine) {
        super(stateMachine,
                0.0,
                125.0,
                Stop.class,
                -1.0,
                1.0);
        // placing the flag
    }
}

