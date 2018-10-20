package org.firstinspires.ftc.teamcode.stateMachine;

public class TurningState extends DrivingState{

    public TurningState(StateMachine stateMachine,
                        Class<? extends StateBase> nextState,
                        boolean isRightTurn){
        super(
             stateMachine,
             .5,
                nextState,
                isRightTurn ? .5 : 0,
                isRightTurn ? 0 : .5
        );
    }
}
