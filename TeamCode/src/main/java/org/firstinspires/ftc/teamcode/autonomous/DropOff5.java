package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.stateMachine.DrivingState;
import org.firstinspires.ftc.teamcode.stateMachine.StateBase;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;



public class DropOff5 extends StateBase {
    protected final Servo servo;
//    protected final Class<? extends StateBase> nextState = State6.class;
     public DropOff5(StateMachine stateMachine) {
        super(stateMachine);
        this.servo = hardwareMap.get(Servo.class,"servo");

    }
    @Override
    public void postEventsCallback() {
        addTelemetry("state","%f","In State");
        sleep(2000);
        this.stateMachine.updateState(State6.class);
}
    @Override
    public void timeUpdate(double sinceOpModePlay, double sinceStateStart) {

        addTelemetry("Time", "%f %f", sinceOpModePlay, sinceStateStart);
    }
}