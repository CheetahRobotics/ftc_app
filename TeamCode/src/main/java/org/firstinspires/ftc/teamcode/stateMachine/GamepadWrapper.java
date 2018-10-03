package org.firstinspires.ftc.teamcode.stateMachine;

import com.qualcomm.robotcore.exception.RobotCoreException;
import com.qualcomm.robotcore.hardware.Gamepad;

public class GamepadWrapper {
    private static final String TAG = "GamepadWrapper";
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
        Gamepad gamepadCopy = new Gamepad();
        // grab a copy so the state doesn't change under us.
        try {
            gamepadCopy.copy(gamepad);
        } catch (RobotCoreException e) {
            e.printStackTrace();
        }
        sendUpdates(gamepadCopy);
        try {
            this.gamepad.copy(gamepadCopy);
        } catch (RobotCoreException e) {
            e.printStackTrace();
        }
    }

    public void updateGamepadListener(GamepadListener gamepadListener) {
        this.gamepadListener = gamepadListener;
    }

    private void sendUpdates(Gamepad gamepad) {

        // floats
        if ((this.gamepad.left_stick_x != gamepad.left_stick_x) ||
                (this.gamepad.left_stick_y != gamepad.left_stick_y))
            this.gamepadListener.left_stick_changed(gamepad.left_stick_x, gamepad.left_stick_y);

        if ((this.gamepad.right_stick_x != gamepad.right_stick_x) ||
                (this.gamepad.right_stick_y != gamepad.right_stick_y))
            this.gamepadListener.right_stick_changed(gamepad.right_stick_x, gamepad.right_stick_y);

        if (this.gamepad.left_trigger != gamepad.left_trigger)
            this.gamepadListener.left_trigger_changed(gamepad.left_trigger);

        if (this.gamepad.right_trigger != gamepad.right_trigger)
            this.gamepadListener.right_trigger_changed(gamepad.right_trigger);

        // booleans
        if (this.gamepad.dpad_up != gamepad.dpad_up)
            this.gamepadListener.dpad_up_changed(gamepad.dpad_up);
        if (this.gamepad.dpad_down != gamepad.dpad_down)
            this.gamepadListener.dpad_down_changed(gamepad.dpad_down);
        if (this.gamepad.dpad_left != gamepad.dpad_left)
            this.gamepadListener.dpad_left_changed(gamepad.dpad_left);
        if (this.gamepad.dpad_right != gamepad.dpad_right)
            this.gamepadListener.dpad_right_changed(gamepad.dpad_right);
        if (this.gamepad.a != gamepad.a) this.gamepadListener.a_changed(gamepad.a);
        if (this.gamepad.b != gamepad.b) this.gamepadListener.b_changed(gamepad.b);
        if (this.gamepad.x != gamepad.x) this.gamepadListener.x_changed(gamepad.x);
        if (this.gamepad.y != gamepad.y) this.gamepadListener.y_changed(gamepad.y);
        if (this.gamepad.start != gamepad.start) this.gamepadListener.start_changed(gamepad.start);
        if (this.gamepad.back != gamepad.back) this.gamepadListener.back_changed(gamepad.back);

        if (this.gamepad.left_bumper != gamepad.left_bumper)
            this.gamepadListener.left_bumper_changed(gamepad.left_bumper);
        if (this.gamepad.right_bumper != gamepad.right_bumper)
            this.gamepadListener.right_bumper_changed(gamepad.right_bumper);
        if (this.gamepad.left_stick_button != gamepad.left_stick_button)
            this.gamepadListener.left_stick_button_changed(gamepad.left_stick_button);
        if (this.gamepad.right_stick_button != gamepad.right_stick_button)
            this.gamepadListener.right_stick_button(gamepad.right_stick_button);
    }
}
