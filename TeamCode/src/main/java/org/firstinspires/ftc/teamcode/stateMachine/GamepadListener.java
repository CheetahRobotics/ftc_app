package org.firstinspires.ftc.teamcode.stateMachine;

public interface GamepadListener {
    void dpadUpChanged(boolean dpad_up);

    void dpadDownChanged(boolean dpad_down);

    void dpadLeftChanged(boolean dpad_left);

    void dpadRightChanged(boolean dpad_right);

    void aChanged(boolean a);

    void bChanged(boolean b);

    void xChanged(boolean x);

    void yChanged(boolean y);

    void startChanged(boolean start);

    void backChanged(boolean back);

    void leftBumperChanged(boolean left_bumper);

    void rightBumperChanged(boolean right_bumper);

    void leftStickButtonChanged(boolean leftStickButton);

    void rightStickButton(boolean rightStickButton);

    void leftStickChanged(float leftStick_x, float leftStick_y);

    void rightStickChanged(float rightStick_x, float rightStick_y);

    void leftTriggerChanged(float left_trigger);

    void rightTriggerChanged(float right_trigger);
}
