package org.firstinspires.ftc.teamcode.stateMachine;

public class TurningState extends DrivingState{

    public TurningState(StateMachine stateMachine,
                        Class<? extends StateBase> nextState,
                        boolean isLeftTurn){
        super(
             stateMachine,
             1.0,
                nextState,
                isLeftTurn ? .5 : 0,
                isLeftTurn ? 0 : .5
        );
    }
}
