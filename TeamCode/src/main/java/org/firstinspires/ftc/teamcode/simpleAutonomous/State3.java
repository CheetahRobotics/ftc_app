package org.firstinspires.ftc.teamcode.simpleAutonomous;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.stateMachine.StateBase;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

public class State3 extends StateBase {
    public State3(StateMachine stateMachine) {
        super(stateMachine);
    }

    @Override
    public void timeUpdate(double sinceOpModePlay, double sinceStateStart) {
        if (sinceStateStart > 2.0) {
            stateMachine.stop();
        }
        addTelemetry("State3 - Time", "%f %f", sinceOpModePlay, sinceStateStart);
    }

    @Override
    public void postEventsCallback() {

        addTelemetry("Motor", "Driving forward");
    }
}
