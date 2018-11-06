package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.stateMachine.GamepadWrapper;
import org.firstinspires.ftc.teamcode.stateMachine.OpModeBase;
import org.firstinspires.ftc.teamcode.stateMachine.RobotCalibration;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

@Autonomous(name = "AutonomousOpMode", group = "Linear Opmode")
public class OpMode extends OpModeBase {
    private static final String TAG = "GamepadListenerBase";

    @Override
    public void initStateMachine(StateMachine stateMachine) {
        // If you want to use this code with a new robot,
        // just update the RobotCallibration numbers on the next line:
        stateMachine.setRobotCalibration(new RobotCalibration(
                11.5,
                288,
                440));

        stateMachine.updateState(State1.class);    // Start at state number 1.
    }

}
