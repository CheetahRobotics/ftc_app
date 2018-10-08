package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.stateMachine.StateBase;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

public class State2 extends StateBase {
    private final DcMotor leftDrive;
    private final DcMotor rightDrive;
    State2(StateMachine stateMachine) {
        super(stateMachine);
        leftDrive  = hardwareMap.get(DcMotor.class, "motor_2");
        rightDrive  = hardwareMap.get(DcMotor.class, "motor_1");
    }

    @Override
    public void timeUpdate(double sinceOpModePlay, double sinceStateStart) {
        if (sinceStateStart > 2.0) {
            leftDrive.setPower(0.5);
            rightDrive.setPower(0.0);
            stateMachine.updateState(3);
        }
        addTelemetry("Time", "%f %f", sinceOpModePlay, sinceStateStart);
    }

    @Override
    public void postEventsCallback() {
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        leftDrive.setPower(0.5);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);

        rightDrive.setPower(-0.5);

        addTelemetry("Motor", "Driving forward");
    }
}

