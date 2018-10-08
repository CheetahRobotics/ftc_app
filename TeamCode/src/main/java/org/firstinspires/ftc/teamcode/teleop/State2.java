package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.teamcode.stateMachine.StateBase;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

import static org.firstinspires.ftc.teamcode.stateMachine.LoggerWrapper.log;

public class State2 extends StateBase {
    private final TouchSensor touchSensor;
    State2(StateMachine stateMachine) {
        super(stateMachine);
        touchSensor = hardwareMap.touchSensor.get("touch_sensor");
    }

    @Override
    public void dpadUpChanged(boolean dpad_up) {
        log("=======> dpad_up ", dpad_up);
        if (dpad_up)
            stateMachine.updateState(3);
    }

    @Override
    public void dpadDownChanged(boolean dpad_down) {
        log("=======> dpad_down ", dpad_down);
        if (dpad_down)
            stateMachine.updateState(1);
    }

    @Override
    public void postEventsCallback() {
        addTelemetry("touch sensor", "%f", touchSensor.getValue());
    }
}
