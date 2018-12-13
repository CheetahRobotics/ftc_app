package org.firstinspires.ftc.teamcode.autonomous;

import org.firstinspires.ftc.teamcode.stateMachine.DrivingState;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

public class KnockJewel4 extends DrivingState {
    public KnockJewel4(StateMachine stateMachine) {
        super(stateMachine,
                0.0,
                2.,
                DropOff5.class,
                0,
                0);
        //Scanning and knocking over the jewel
    }
}


