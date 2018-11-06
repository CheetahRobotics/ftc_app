package org.firstinspires.ftc.teamcode.encoderExampleAutonomous;

import org.firstinspires.ftc.teamcode.stateMachine.DrivingState;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;
import org.firstinspires.ftc.teamcode.stateMachine.Stop;

public class Drive1Rotations extends DrivingState {

    public Drive1Rotations(StateMachine stateMachine) {
        super(stateMachine,
                0.0,
                stateMachine.getRobotCalibration().wheelCircumfrenceInches,
                TurnLeft.class,
                -0.5,
                .5);
    }
}
