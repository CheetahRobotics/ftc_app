package org.firstinspires.ftc.teamcode.teleop;

import org.firstinspires.ftc.teamcode.stateMachine.StateBase;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

public class State1 extends StateBase {
    public State1(StateMachine stateMachine) {
        super(stateMachine);
    }
    public void dpad_up_changed(boolean dpad_up) {
        log("=======> dpad_up ", dpad_up);
        if (dpad_up) {
            stateMachine.updateState(2);
        }
    }


    public void dpad_down_changed(boolean dpad_down) {
        log("=======> dpad_down ", dpad_down);
        if (dpad_down) {
            stateMachine.updateState(3);
        }
    }
    public void dpad_left_changed(boolean dpad_left) {
        log("=======> dpad_left ", dpad_left);
        if (dpad_left) {
            addTelemetry("Motor", "Driving forward");
        }
    }
    public void dpad_right_changed(boolean dpad_right) {
        log("=======> dpad_right ", dpad_right);
        if (dpad_right) {
            addTelemetry("Motor", "Driving backwards");
        }
    }
    public void timeUpdate(double sinceOpModePlay, double sinceStateStart) {
        addTelemetry("Time", "%f %f", sinceOpModePlay, sinceStateStart);

    }

    public void postEvents() {

        // this is called after all events
    }
}
