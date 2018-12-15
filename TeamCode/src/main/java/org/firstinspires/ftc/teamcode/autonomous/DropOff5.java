package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.stateMachine.DrivingState;
import org.firstinspires.ftc.teamcode.stateMachine.StateBase;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;



public abstract class  DropOff5 extends StateBase {
    protected final Servo servo;
    protected final Class<? extends StateBase> nextState;

    public DropOff5(StateMachine stateMachine,
                     Class<? extends StateBase> nextState) {
        super(stateMachine);

        this.nextState = nextState;
        this.servo = hardwareMap.get(Servo.class,"servo");
        this.servo.setPosition(0);
        this.servo.setPosition(.25);
    }
    @Override
    public void postEventsCallback() {
        addTelemetry("state","%f","In State");
        sleep(2000);
        this.stateMachine.updateState(State6.class);
}
    @Override
    public void timeUpdate(double sinceOpModePlay, double sinceStateStart) {
        if (sinceStateStart >0) {
            stateMachine.updateState(nextState);
        }
        addTelemetry("Time", "%f %f", sinceOpModePlay, sinceStateStart);
    }
}