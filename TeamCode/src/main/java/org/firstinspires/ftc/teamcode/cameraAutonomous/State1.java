package org.firstinspires.ftc.teamcode.cameraAutonomous;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.teamcode.stateMachine.StateBase;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

class State1 extends StateBase {
    State1(StateMachine stateMachine) {
        super(stateMachine);
    }

    @Override
    public void timeUpdate(double sinceOpModePlay, double sinceStateStart) {
        addTelemetry("State1 - Time", "%f %f", sinceOpModePlay, sinceStateStart);
    }

    @Override
    public void postEventsCallback() {
        addTelemetry("Motor", "Driving forward");
    }
}
