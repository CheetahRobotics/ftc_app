package org.firstinspires.ftc.teamcode.autonomous;

import org.firstinspires.ftc.teamcode.stateMachine.DrivingState;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

public class PlaceFlag extends DrivingState {
    public  PlaceFlag(StateMachine stateMachine) {
        super(stateMachine,
                2.,
                State11.class,
                0,
                0);
        // placing the flag
    }
}
