package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.exception.RobotCoreException;
import com.qualcomm.robotcore.hardware.Gamepad;

public class GamepadWrapper {
    private GamepadListener gamepadListener;
    private Gamepad gamepad = new Gamepad();

    public GamepadWrapper(Gamepad gamepad) {
        try {
            this.gamepad.copy(gamepad);
        } catch (RobotCoreException e) {
            e.printStackTrace();
        }
    }

    public void updateGamepadState(Gamepad gamepad) {
        sendUpdates(gamepad);
        try {
            this.gamepad.copy(gamepad);
        } catch (RobotCoreException e) {
            e.printStackTrace();
        }
    }

    public void updateGamepadListener(GamepadListener gamepadListener) {
        this.gamepadListener = gamepadListener;
    }

    private void sendUpdates(Gamepad gamepad) {
//        public float left_stick_x = 0f;
//        public float left_stick_y = 0f;
//        public float right_stick_x = 0f;
//        public float right_stick_y = 0f;
//        public float left_trigger = 0f;
//        public float right_trigger = 0f;

        if (this.gamepad.dpad_up != gamepad.dpad_up)
            this.gamepadListener.dpad_up_changed(gamepad.dpad_up);
        if (this.gamepad.dpad_down != gamepad.dpad_down)
            this.gamepadListener.dpad_down_changed(gamepad.dpad_down);
        if (this.gamepad.dpad_left != gamepad.dpad_left)
            this.gamepadListener.dpad_left_changed(gamepad.dpad_left);
        if (this.gamepad.dpad_right != gamepad.dpad_right)
            this.gamepadListener.dpad_right_changed(gamepad.dpad_right);
//        if (this.gamepad.a != gamepad.a) this.gamepadListener.a_changed(gamepad.a);
//        if (this.gamepad.b != gamepad.b) this.gamepadListener.b_changed(gamepad.b);
//        if (this.gamepad.x != gamepad.x) this.gamepadListener.x_changed(gamepad.x);
//        if (this.gamepad.y != gamepad.y) this.gamepadListener.y_changed(gamepad.y);
//        if (this.gamepad.start != gamepad.start) this.gamepadListener.start_changed(gamepad.start);
//        if (this.gamepad.back != gamepad.back) this.gamepadListener.back_changed(gamepad.back);
//        if (this.gamepad.left_bumper != gamepad.left_bumper)
//            this.gamepadListener.left_bumper_changed(gamepad.left_bumper);
//        if (this.gamepad.right_bumper != gamepad.right_bumper)
//            this.gamepadListener.right_bumper_changed(gamepad.right_bumper);
//        if (this.gamepad.left_stick_button != gamepad.left_stick_button)
//            this.gamepadListener.left_stick_button_changed(gamepad.left_stick_button);
//        if (this.gamepad.right_stick_button != gamepad.right_stick_button)
//            this.gamepadListener.right_stick_button(gamepad.right_stick_button);
    }
}
