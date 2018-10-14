package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.stateMachine.GamepadWrapper;
import org.firstinspires.ftc.teamcode.stateMachine.OpModeBase;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

@TeleOp(name = "TeleOpMode", group = "Linear Opmode")
public class TeleOpMode extends OpModeBase {

    @Override
    public void initStateMachine(StateMachine stateMachine) {
        stateMachine.updateState(State1.class);    // Start at state number 1.
    }

}
