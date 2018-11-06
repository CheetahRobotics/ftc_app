package org.firstinspires.ftc.teamcode.encoderExampleAutonomous;

import org.firstinspires.ftc.teamcode.autonomous.State2;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;
import org.firstinspires.ftc.teamcode.stateMachine.TurningState;

public class TurnLeft extends TurningState {
    public TurnLeft(StateMachine stateMachine) {
        super(stateMachine,
                State2.class,
                    true
                );
    }
}
