package org.firstinspires.ftc.teamcode.autonomous;

import org.firstinspires.ftc.teamcode.stateMachine.DrivingState;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;
import org.firstinspires.ftc.teamcode.stateMachine.TurningState;

public class State8 extends TurningState {
    public  State8(StateMachine stateMachine) {
        super(stateMachine,
                State9.class,
                false);
    }
}
