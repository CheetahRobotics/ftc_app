package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.stateMachine.DrivingState;
import org.firstinspires.ftc.teamcode.stateMachine.StateBase;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

public class State3 extends DrivingState {
    public State3(StateMachine stateMachine) {
        super(stateMachine,
                2,
                KnockJewel.class,
                0.5,
                -.5);
    }
}
