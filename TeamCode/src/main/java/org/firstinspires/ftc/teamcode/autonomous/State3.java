package org.firstinspires.ftc.teamcode.autonomous;

import org.firstinspires.ftc.teamcode.stateMachine.DrivingState;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

public class State3 extends DrivingState {
    public State3(StateMachine stateMachine) {
        super(stateMachine,
                0.0,
                27.0,
               DropOff5.class,
                0.5,
                -0.5);
    }
}

