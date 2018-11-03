package org.firstinspires.ftc.teamcode.stateMachine;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.stateMachine.StateBase;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

public abstract class DrivingState extends StateBase {
    protected final DcMotor leftDrive;
    protected final DcMotor rightDrive;
    private final double timeToDriveInSeconds;
    protected final Class<? extends StateBase> nextState;
    private final double leftPower;
    private final double rightPower;
    private final boolean usingEncoders;

    // Time based driving
    public DrivingState(StateMachine stateMachine,
                        double timeToDriveInSeconds,
                        Class<? extends StateBase> nextState,
                        double leftPower,
                        double rightPower) {
        super(stateMachine);
        leftDrive = hardwareMap.get(DcMotor.class, "motor_2");
        rightDrive = hardwareMap.get(DcMotor.class, "motor_1");
        this.timeToDriveInSeconds = timeToDriveInSeconds;
        this.nextState = nextState;
        this.leftPower = leftPower;
        this.rightPower = rightPower;
        this.usingEncoders = false;
    }

    // Encoder based driving
    public DrivingState(StateMachine stateMachine,
                        Class<? extends StateBase> nextState,
                        double leftPower,
                        double rightPower) {
        super(stateMachine);
        leftDrive = hardwareMap.get(DcMotor.class, "motor_2");
        rightDrive = hardwareMap.get(DcMotor.class, "motor_1");
        this.timeToDriveInSeconds = 100000;
        this.nextState = nextState;
        this.leftPower = leftPower;
        this.rightPower = rightPower;
        this.usingEncoders = true;

        // TODO: we may want to enable stop and FLOAT.
        leftDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public void timeUpdate(double sinceOpModePlay, double sinceStateStart) {
        if (sinceStateStart > timeToDriveInSeconds) {
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
    }

    protected void stopMotors() {
        leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftDrive.setPower(0.0);
        rightDrive.setPower(0.0);
    }
}
