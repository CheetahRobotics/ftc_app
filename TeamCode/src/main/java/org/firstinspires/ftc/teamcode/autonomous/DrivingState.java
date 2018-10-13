package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.stateMachine.StateBase;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

public class DrivingState extends StateBase {
    private final DcMotor leftDrive;
    private final DcMotor rightDrive;
    private final double timeToDrive;
    private final int nextState;
    private final double leftPower;
    private final double rightPower;
    DrivingState(StateMachine stateMachine,
                 double timeToDrive,
                 int nextState,
                 double leftPower,
                 double rightPower) {
        super(stateMachine);
        leftDrive = hardwareMap.get(DcMotor.class, "motor_2");
        rightDrive = hardwareMap.get(DcMotor.class, "motor_1");
        this.timeToDrive = timeToDrive;
        this.nextState = nextState;
        this.leftPower = leftPower;
        this.rightPower = rightPower;
    }
    @Override
    public void timeUpdate(double sinceOpModePlay, double sinceStateStart) {
        if (sinceStateStart > timeToDrive) {
            stateMachine.updateState(nextState);
        }
        addTelemetry("Time", "%f %f", sinceOpModePlay, sinceStateStart);
    }

    @Override
    public void postEventsCallback() {
        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        leftDrive.setPower(leftPower);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setPower(rightPower);
        addTelemetry("Motor", "Driving forward");
    }

}
