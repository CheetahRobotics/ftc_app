package org.firstinspires.ftc.teamcode.stateMachine;

import static org.firstinspires.ftc.teamcode.stateMachine.LoggerWrapper.log;

public class GamepadListenerBase implements GamepadListener {
    private static final String TAG = "GamepadListenerBase";

    public void dpadUpChanged(boolean dpad_up) {
        log(TAG, "dpad_up", dpad_up);
    }

    public void dpadDownChanged(boolean dpad_down) {
        log(TAG, "dpad_down", dpad_down);
    }

    public void dpadLeftChanged(boolean dpad_left) {
        log(TAG, "dpad_left", dpad_left);
    }

    public void dpadRightChanged(boolean dpad_right) {
        log(TAG, "dpad_right", dpad_right);
    }

    public void aChanged(boolean value) {
        log(TAG, "a", value);
    }

    public void bChanged(boolean value) {
        log(TAG, "b", value);
    }

    public void xChanged(boolean value) {
        log(TAG, "x", value);
    }

    public void yChanged(boolean value) {
        log(TAG, "y", value);
    }

    public void startChanged(boolean value) {
        log(TAG, "start", value);
    }

    public void backChanged(boolean value) {
        log(TAG, "back", value);
    }

    public void leftBumperChanged(boolean value) {

        log(TAG, "left_bumper", value);
    }

    public void rightBumperChanged(boolean value) {
        log(TAG, "right_bumper", value);
    }

    public void leftStickButtonChanged(boolean value) {
        log(TAG, "left_stick button", value);
    }

    public void rightStickButton(boolean value) {
        log(TAG, "right_stick button", value);
    }
    public void leftStickChanged(float left_stick_x, float left_stick_y) {
        log(TAG, "left stick: X: %f, Y: %f", left_stick_x, left_stick_y);
    }

    public void rightStickChanged(float right_stick_x, float right_stick_y) {
        log(TAG, "right stick: X: %f, Y: %f", right_stick_x, right_stick_y);
    }
    
    public void leftTriggerChanged(float left_trigger) {
        log(TAG, "left trigger: %f", left_trigger);
    }

    public void rightTriggerChanged(float right_trigger) {
        log(TAG, "right trigger: %f", right_trigger);
    }

}
