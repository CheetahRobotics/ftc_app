package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.stateMachine.DrivingState;
import org.firstinspires.ftc.teamcode.stateMachine.StateBase;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

public class State3 extends DrivingState {
    static final double COUNTS_PER_MOTOR = 240;

    public State3(StateMachine stateMachine) {
        super(stateMachine,
                0.0,
                27.0,
                PlaceFlag.class,
                -0.5,
                .5);
    }
}

