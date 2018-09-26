package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.RobotLog;

public class GamepadListenerBase implements GamepadListener {
    private static final String TAG = "GamepadListenerBase";

    private OpModeBase.LogLevel logLevel = OpModeBase.LogLevel.Verbose;

    void log(String label, boolean newValue) {
        if (this.logLevel == OpModeBase.LogLevel.Verbose) {
            RobotLog.ii(TAG, "----> %s: %b", label, newValue);
        }
    }
    public void dpad_up_changed(boolean dpad_up) {
        log("dpad_up", dpad_up);
    }

    public void dpad_down_changed(boolean dpad_down){
        log("dpad_down", dpad_down);
    }

    public void dpad_left_changed(boolean dpad_left){
        log("dpad_left", dpad_left);
    }

    public void dpad_right_changed(boolean dpad_right){
        log("dpad_right", dpad_right);
    }

}
