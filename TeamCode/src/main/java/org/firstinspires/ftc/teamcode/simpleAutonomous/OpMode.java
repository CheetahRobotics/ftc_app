package org.firstinspires.ftc.teamcode.simpleAutonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.stateMachine.GamepadWrapper;
import org.firstinspires.ftc.teamcode.stateMachine.OpModeBase;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

@Autonomous(name = "SimpleAutonomousOpMode", group = "Linear Opmode")
public class OpMode extends OpModeBase {
    private static final String TAG = "GamepadListenerBase";

    @Override
    public void setupStates(StateMachine stateMachine) {
//        stateMachine.registerTouchSensor("touch_sensor");
        stateMachine.addNewState(1, new State1(stateMachine));
        stateMachine.addNewState(2, new State2(stateMachine));
        stateMachine.addNewState(3, new State3(stateMachine));
        stateMachine.updateState(1);    // Start at state number 1.
    }

}
