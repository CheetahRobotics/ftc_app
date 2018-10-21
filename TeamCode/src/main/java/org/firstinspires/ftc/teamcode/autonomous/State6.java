package org.firstinspires.ftc.teamcode.autonomous;

import org.firstinspires.ftc.teamcode.stateMachine.DrivingState;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;
import org.firstinspires.ftc.teamcode.stateMachine.TurningState;

public class State6 extends TurningState {
    State6(StateMachine stateMachine) {
        super(stateMachine,
                State7.class,
                true);
    }
}
