package org.firstinspires.ftc.teamcode.teleop;

import org.firstinspires.ftc.teamcode.StateBase;

public class State1 extends StateBase {
    public void dpad_up_changed(boolean dpad_up) {
        log("=======> dpad_up ", dpad_up);
        if (dpad_up)
            stateMachine.updateState(2);
    }


    public void dpad_down_changed(boolean dpad_down) {
        log("=======> dpad_down ", dpad_down);
        if (dpad_down)
            stateMachine.updateState(3);
    }
}
