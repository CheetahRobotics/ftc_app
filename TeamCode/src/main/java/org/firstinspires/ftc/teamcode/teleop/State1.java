package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.RobotLog;

import org.firstinspires.ftc.teamcode.State;
import org.firstinspires.ftc.teamcode.StateBase;

public class State1 extends StateBase implements State {
    private static final String TAG = "AutonomousOpMode";
    State1(HardwareMap hardwareMap, Gamepad gamepad) {
        super(hardwareMap, gamepad);
    }
    public void dpad_up_changed(boolean dpad_up) {
        RobotLog.ii(TAG,"I ONLY CARE ABOUT dpad_up %b", dpad_up);  // TODO: fix logging!!
    }
}
