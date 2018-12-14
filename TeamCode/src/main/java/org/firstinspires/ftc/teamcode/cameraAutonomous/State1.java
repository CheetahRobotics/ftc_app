package org.firstinspires.ftc.teamcode.cameraAutonomous;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.encoderExampleAutonomous.TurnLeft;
import org.firstinspires.ftc.teamcode.stateMachine.StateBase;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

public class State1 extends StateBase {
    public State1(StateMachine stateMachine) {
        super(stateMachine);
    }

    @Override
    public void timeUpdate(double sinceOpModePlay, double sinceStateStart) {
        OpMode opmode = (OpMode) stateMachine.opMode();

        addTelemetry("H Value", "%f", opmode.getH());
    }

    @Override
    public void dpadUpChanged(boolean dpad_up) {
        if (dpad_up) {
            OpMode opmode = (OpMode) stateMachine.opMode();
            opmode.incrementView();
        }
    }
    @Override
    public void dpadRightChanged(boolean dpad_right) {
        if (dpad_right) {
            OpMode opmode = (OpMode) stateMachine.opMode();
            opmode.incrementH();
        }
    }

    @Override
    public void dpadLeftChanged(boolean dpad_left) {
        if (dpad_left) {
            OpMode opmode = (OpMode) stateMachine.opMode();
            opmode.decrementH();
        }
    }

    @Override
    public void postEventsCallback() {
        OpMode opmode = (OpMode) stateMachine.opMode();
        addTelemetry("Blob Center", "%f, %f",
                opmode.getCenterOfBiggestBlob().x,
                opmode.getCenterOfBiggestBlob().y);

        double leftPower;
        double rightPower;

        DcMotor leftDrive  = hardwareMap.get(DcMotor.class, "motor_1");
        DcMotor rightDrive = hardwareMap.get(DcMotor.class, "motor_2");
        double drive = .5;
        double turn = 0.0;

        if (opmode.getCenterOfBiggestBlob().x > 80) {
            addTelemetry("Turn", "Right");

        } else {
            addTelemetry("Turn", "Left");

        }
        leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
        rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;
        leftDrive.setPower(leftPower);
        rightDrive.setPower(rightPower);
    }
}