package org.firstinspires.ftc.teamcode.encoderExampleAutonomous;

import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;
import org.firstinspires.ftc.teamcode.stateMachine.TurningState;

public class TurnLeft extends TurningState {
    public TurnLeft(StateMachine stateMachine) {
        super(stateMachine,
                Drive1Rotations.class,
                    true
                );
    }
}
