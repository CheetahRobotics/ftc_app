package org.firstinspires.ftc.teamcode.teleop;

import org.firstinspires.ftc.teamcode.stateMachine.StateBase;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

import static org.firstinspires.ftc.teamcode.stateMachine.LoggerWrapper.log;

public class State3 extends StateBase {
    State3(StateMachine stateMachine) {
        super(stateMachine);
    }

    public void dpadUpChanged(boolean dpad_up) {
        log("=======> dpad_up ", dpad_up);
        if (dpad_up)
            stateMachine.updateState(1);
    }


    public void dpadDownChanged(boolean dpad_down) {
        log("=======> dpad_up ", dpad_down);
        if (dpad_down)
            stateMachine.updateState(2);

    }


}
