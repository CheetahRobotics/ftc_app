package org.firstinspires.ftc.teamcode.autonomous;

import org.firstinspires.ftc.teamcode.stateMachine.DrivingState;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

class KnockJewel  extends DrivingState {
    KnockJewel(StateMachine stateMachine) {
        super(stateMachine,
                2.,
                State5.class,
                0,
                0);
    }
}


