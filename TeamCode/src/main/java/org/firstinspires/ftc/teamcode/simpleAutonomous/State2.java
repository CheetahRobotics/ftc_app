package org.firstinspires.ftc.teamcode.simpleAutonomous;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.stateMachine.StateBase;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

public class State2 extends StateBase {
    public State2(StateMachine stateMachine) {
        super(stateMachine);
    }

    @Override
    public void timeUpdate(double sinceOpModePlay, double sinceStateStart) {
        if (sinceStateStart > 3.0) {
            stateMachine.updateState(State3.class);
        }
        addTelemetry("State2 - Time", "%f %f", sinceOpModePlay, sinceStateStart);
    }

    @Override
    public void postEventsCallback() {
        addTelemetry("Motor", "Driving forward");
    }
}

