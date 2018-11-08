package org.firstinspires.ftc.teamcode.autonomous;

import org.firstinspires.ftc.teamcode.stateMachine.DrivingState;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;
import org.firstinspires.ftc.teamcode.stateMachine.Stop;

public class PlaceFlag extends DrivingState {
    static final double COUNTS_PER_MOTOR = 240;

    public PlaceFlag(StateMachine stateMachine) {
        super(stateMachine,
                0.0,
                100.0,
                Stop.class,
                0.5,
                -.5);
        // placing the flag
    }
}

