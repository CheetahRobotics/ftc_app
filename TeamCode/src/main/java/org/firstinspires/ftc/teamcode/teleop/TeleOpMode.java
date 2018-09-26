package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.GamepadWrapper;
import org.firstinspires.ftc.teamcode.OpModeBase;
import org.firstinspires.ftc.teamcode.State;
import org.firstinspires.ftc.teamcode.StateMachine;

import java.util.HashMap;

@TeleOp(name = "TeleOpMode", group = "Linear Opmode")
public class TeleOpMode extends OpModeBase {
    private static final String TAG = "GamepadListenerBase";

    @Override
    public void runOpMode() {
        HashMap<Integer, State> states = new HashMap<>();
        states.put(1, new State1(hardwareMap, gamepad1));
        this.gamepadWrapper = new GamepadWrapper(gamepad1);
        StateMachine stateMachine = new StateMachine(states, gamepadWrapper);

        // hand over everything from here on to OpModeBase
        runOpModeBase();
    }
}
