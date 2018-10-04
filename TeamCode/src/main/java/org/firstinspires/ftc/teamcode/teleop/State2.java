package org.firstinspires.ftc.teamcode.teleop;

import org.firstinspires.ftc.teamcode.stateMachine.StateBase;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

import static org.firstinspires.ftc.teamcode.stateMachine.LoggerWrapper.log;

public class State2 extends StateBase {
    State2(StateMachine stateMachine) {
        super(stateMachine);
    }

    public void dpad_up_changed(boolean dpad_up) {
        log("=======> dpad_up ", dpad_up);
        if (dpad_up)
            stateMachine.updateState(3);
    }

    public void dpad_down_changed(boolean dpad_down) {
        log("=======> dpad_down ", dpad_down);
        if (dpad_down)
            stateMachine.updateState(1);
    }

}
