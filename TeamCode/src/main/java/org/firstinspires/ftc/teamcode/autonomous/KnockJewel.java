package org.firstinspires.ftc.teamcode.autonomous;

import org.firstinspires.ftc.teamcode.stateMachine.DrivingState;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

public class KnockJewel  extends DrivingState {
    public  KnockJewel(StateMachine stateMachine) {
        super(stateMachine,
                2.,
                PlaceFlag.class,
                0,
                0);
        //Scaning and knocking over the jewel
    }
}


