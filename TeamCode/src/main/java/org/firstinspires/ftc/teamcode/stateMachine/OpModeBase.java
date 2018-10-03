package org.firstinspires.ftc.teamcode.stateMachine;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.RobotLog;


public class OpModeBase extends LinearOpMode
{
    private static String TAG = "OpModeBase";

    // Declare OpMode members.
    protected ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    protected GamepadWrapper gamepadWrapper;
    protected StateMachine stateMachine;

    public void setupStates(StateMachine s) {
        throw new RuntimeException("No states defined. You need to define some states. Stopping.");
    }

    @Override
    public void runOpMode() {
        RobotLog.ii(TAG, "------- START ----------");

        this.gamepadWrapper = new GamepadWrapper(gamepad1);
        stateMachine = new StateMachine(hardwareMap, gamepadWrapper, telemetry, runtime);
        setupStates(stateMachine);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            stateMachine.preEventsCallback();
            // this is where all the gamepad-related callbacks get fired.
            gamepadWrapper.updateGamepadState(gamepad1);
            stateMachine.postEventsCallback();

            double drive = gamepad1.left_stick_y;
            double turn  =  gamepad1.right_stick_x;

            telemetry.addData("State", stateMachine.currentStateAsString());

            if (LoggerWrapper.logLevel == LoggerWrapper.LogLevel.VerboseWithTelemetry) {
                telemetry.addData("Status", "Run Time: " + runtime.toString());
                telemetry.addData("Left Stick", "Left Stick. X (%.2f), Y (%.2f). Right Stick. X (%.2f), Y (%.2f).",
                        gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x, gamepad1.right_stick_y);
                telemetry.addData("Trigger", "Left (%.2f), Right(%.2f)", gamepad1.left_trigger, gamepad1.right_trigger);
                telemetry.addData("Button", "Left (%b), Right(%b)", gamepad1.left_stick_button, gamepad1.right_stick_button);
                telemetry.addData("Bumper", "Left (%b), Right(%b)", gamepad1.left_bumper, gamepad1.right_bumper);
                telemetry.addData("DPad", "Up (%b), Down(%b), Left(%b), Right(%b)",
                        gamepad1.dpad_up, gamepad1.dpad_down, gamepad1.dpad_left, gamepad1.dpad_right);
            }
            telemetry.update();
        }
    }
}
