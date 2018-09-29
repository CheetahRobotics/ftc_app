package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.teamcode.LoggerWrapper;

import static org.firstinspires.ftc.teamcode.LoggerWrapper.log;

public class GamepadListenerBase implements GamepadListener {
    private static final String TAG = "GamepadListenerBase";

    public void dpad_up_changed(boolean dpad_up) {
        log(TAG, "dpad_up", dpad_up);
    }

    public void dpad_down_changed(boolean dpad_down) {
        log(TAG, "dpad_down", dpad_down);
    }

    public void dpad_left_changed(boolean dpad_left) {
        log(TAG, "dpad_left", dpad_left);
    }

    public void dpad_right_changed(boolean dpad_right) {
        log(TAG, "dpad_right", dpad_right);
    }

    public void a_changed(boolean value) {
        log(TAG, "a", value);
    }

    public void b_changed(boolean value) {
        log(TAG, "b", value);
    }

    public void x_changed(boolean value) {
        log(TAG, "x", value);
    }

    public void y_changed(boolean value) {
        log(TAG, "y", value);
    }

    public void start_changed(boolean value) {
        log(TAG, "start", value);
    }

    public void back_changed(boolean value) {
        log(TAG, "back", value);
    }

    public void left_bumper_changed(boolean value) {

        log(TAG, "left_bumper", value);
    }

    public void right_bumper_changed(boolean value) {
        log(TAG, "right_bumper", value);
    }

    public void left_stick_button_changed(boolean value) {
        log(TAG, "left_stick button", value);
    }

    public void right_stick_button(boolean value) {
        log(TAG, "right_stick button", value);
    }
    public void left_stick_changed(float left_stick_x, float left_stick_y) {
        log(TAG, "left stick: X: %f, Y: %f", left_stick_x, left_stick_y);
    }

    public void right_stick_changed(float right_stick_x, float right_stick_y) {
        log(TAG, "right stick: X: %f, Y: %f", right_stick_x, right_stick_y);
    }
    
    public void left_trigger_changed(float left_trigger) {
        log(TAG, "left trigger: %f", left_trigger);
    }

    public void right_trigger_changed(float right_trigger) {
        log(TAG, "right trigger: %f", right_trigger);
    }

}
