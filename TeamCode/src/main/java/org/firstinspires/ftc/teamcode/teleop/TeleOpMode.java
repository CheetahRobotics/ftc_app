package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.stateMachine.GamepadWrapper;
import org.firstinspires.ftc.teamcode.stateMachine.OpModeBase;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

@TeleOp(name = "TeleOpMode", group = "Linear Opmode")
public class TeleOpMode extends OpModeBase {
    private static final String TAG = "GamepadListenerBase";

    @Override
    public void runOpMode() {

        this.gamepadWrapper = new GamepadWrapper(gamepad1);
        StateMachine stateMachine = new StateMachine(hardwareMap, gamepadWrapper, telemetry);

        // Don't change anything before this line.
        // The only time you need to modify this class is to add new states....
        // Right here:

        stateMachine.addNewState(1, new State1());
        stateMachine.addNewState(2, new State2());
        stateMachine.addNewState(3, new State3());
        stateMachine.updateState(1);    // Start at state number 1.

        // Don't change anything after this line.

        // hand over everything from here on to OpModeBase
        runOpModeBase(stateMachine);
    }
}
