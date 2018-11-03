package org.firstinspires.ftc.teamcode.autonomous;

import org.firstinspires.ftc.teamcode.stateMachine.DrivingState;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

public class Stop  extends DrivingState {
    public  Stop (StateMachine stateMachine) {
        super(stateMachine,
                Stop.class,
                0,
                0);

        stopMotors();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stateMachine.stop();

    }
}