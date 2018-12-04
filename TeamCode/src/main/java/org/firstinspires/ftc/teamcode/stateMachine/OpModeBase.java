package org.firstinspires.ftc.teamcode.stateMachine;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.exception.RobotCoreException;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.RobotLog;

import org.firstinspires.ftc.robotcontroller.internal.FtcRobotControllerActivity;
import org.opencv.android.CameraBridgeViewBase;


public class OpModeBase extends LinearOpMode
{
    private static String TAG = "OpModeBase";

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private GamepadWrapper gamepadWrapper;
    protected StateMachine stateMachine;

    public void initStateMachine(StateMachine s) {
        throw new RuntimeException("No states defined. You need to define some states. Stopping.");
    }

    private Gamepad snapGamepad(Gamepad gamepad) {
        Gamepad gamepadCopy = new Gamepad();
        // grab a copy so the state doesn't change under us.
        try {
            gamepadCopy.copy(gamepad);
        } catch (RobotCoreException e) {
            e.printStackTrace();
        }
        return gamepadCopy;        
    }


    public void beforeLoop() {

    }

    public void afterLoop() {

    }

    @Override
    public void runOpMode() {
        RobotLog.ii(TAG, "------- START ----------");

        this.gamepadWrapper = new GamepadWrapper(gamepad1);
        stateMachine = new StateMachine(hardwareMap, gamepadWrapper, telemetry, runtime, this);
        initStateMachine(stateMachine);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        beforeLoop();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            Gamepad gamepadSnap = snapGamepad(gamepad1);
            stateMachine.setGamepad(gamepadSnap);
            stateMachine.preEventsCallback();
            // this is where all the gamepad-related callbacks get fired.
            gamepadWrapper.updateGamepadState(gamepadSnap);
            stateMachine.doSensorCallbacks();
            stateMachine.postEventsCallback();

            double drive = gamepadSnap.left_stick_y;
            double turn  =  gamepadSnap.right_stick_x;

            telemetry.addData("State", stateMachine.currentStateAsString());

            if (LoggerWrapper.logLevel == LoggerWrapper.LogLevel.VerboseWithTelemetry) {
                telemetry.addData("Status", "Run Time: " + runtime.toString());
                telemetry.addData("Left Stick", "Left Stick. X (%.2f), Y (%.2f). Right Stick. X (%.2f), Y (%.2f).",
                        gamepadSnap.left_stick_x, gamepadSnap.left_stick_y, gamepadSnap.right_stick_x, gamepadSnap.right_stick_y);
                telemetry.addData("Trigger", "Left (%.2f), Right(%.2f)", gamepadSnap.left_trigger, gamepadSnap.right_trigger);
                telemetry.addData("Button", "Left (%b), Right(%b)", gamepadSnap.left_stick_button, gamepadSnap.right_stick_button);
                telemetry.addData("Bumper", "Left (%b), Right(%b)", gamepadSnap.left_bumper, gamepadSnap.right_bumper);
                telemetry.addData("DPad", "Up (%b), Down(%b), Left(%b), Right(%b)",
                        gamepadSnap.dpad_up, gamepadSnap.dpad_down, gamepadSnap.dpad_left, gamepadSnap.dpad_right);
            }
            telemetry.update();
        }
        afterLoop();
    }
    public void startOpenCV(CameraBridgeViewBase.CvCameraViewListener2 cameraViewListener) {
        FtcRobotControllerActivity.turnOnCameraView.obtainMessage(1, cameraViewListener).sendToTarget();
    }

    public void stopOpenCV() {
        FtcRobotControllerActivity.turnOffCameraView.obtainMessage().sendToTarget();
    }
}
