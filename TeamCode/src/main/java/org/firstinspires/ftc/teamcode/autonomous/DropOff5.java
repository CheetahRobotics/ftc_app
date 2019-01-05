package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.stateMachine.DrivingState;
import org.firstinspires.ftc.teamcode.stateMachine.StateBase;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;
import org.firstinspires.ftc.teamcode.stateMachine.Stop;


public class DropOff5 extends StateBase {
    protected Servo servo;
    private Boolean doneWithServo = false;

    public DropOff5(StateMachine stateMachine) {
        super(stateMachine);

    }

//    @Override
//    public void postEventsCallback() {
//        addTelemetry("state", "%f", "In State");
//        sleep(2000);
//        this.stateMachine.updateState(State6.class);
//    }

    @Override
    public void timeUpdate(double sinceOpModePlay, double sinceStateStart) {
        this.servo = hardwareMap.get(Servo.class, "servo");
        if (sinceStateStart > 5) {
            stateMachine.updateState(Stop.class);
        }
        else if (sinceStateStart > 3) {
            this.servo.setPosition(.25);
        }
        else  {
            this.servo.setPosition(1.0);
        }
        addTelemetry("Time", "%f %f", sinceOpModePlay, sinceStateStart);
        addTelemetry("Position", "%f ",this.servo.getPosition());
}
}