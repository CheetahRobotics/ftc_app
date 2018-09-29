package org.firstinspires.ftc.teamcode;

public interface GamepadListener {
    void dpad_up_changed(boolean dpad_up);

    void dpad_down_changed(boolean dpad_down);

    void dpad_left_changed(boolean dpad_left);

    void dpad_right_changed(boolean dpad_right);

    void a_changed(boolean a);

    void b_changed(boolean b);

    void x_changed(boolean x);

    void y_changed(boolean y);

    void start_changed(boolean start);

    void back_changed(boolean back);

    void left_bumper_changed(boolean left_bumper);

    void right_bumper_changed(boolean right_bumper);

    void left_stick_button_changed(boolean left_stick_button);

    void right_stick_button(boolean right_stick_button);

    void left_stick_changed(float left_stick_x, float left_stick_y);

    void right_stick_changed(float right_stick_x, float right_stick_y);

    void left_trigger_changed(float left_trigger);

    void right_trigger_changed(float right_trigger);
}
