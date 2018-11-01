package org.firstinspires.ftc.teamcode.encoderExampleAutonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.encoderExampleAutonomous.Drive1Rotations;
import org.firstinspires.ftc.teamcode.stateMachine.GamepadWrapper;
import org.firstinspires.ftc.teamcode.stateMachine.OpModeBase;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

@Autonomous(name = "EncoderExampleAutonomousOpMode", group = "Linear Opmode")
public class OpMode extends OpModeBase {
    private static final String TAG = "GamepadListenerBase";

    @Override
    public void initStateMachine(StateMachine stateMachine) {
        stateMachine.updateState(TurnLeft.class);    // Start at state number 1.
    }

}
