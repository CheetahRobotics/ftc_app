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
        RobotLog.ii(TAG,"=======> dpad_up %b", dpad_up);  // TODO: fix logging!!
    }
    public void dpad_left_changed(boolean dpad_left) {
        RobotLog.ii(TAG,"=======> dpad_left %b", dpad_left);  // TODO: fix logging!!
    }
    public void dpad_down_changed(boolean dpad_down) {
        RobotLog.ii(TAG,"=======> dpad_down %b", dpad_down);  // TODO: fix logging!!
    }
    public void dpad_right_changed(boolean dpad_right) {
        RobotLog.ii(TAG,"=======> dpad_right %b", dpad_right);  // TODO: fix logging!!
    }
}
