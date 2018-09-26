package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class StateBase extends GamepadListenerBase {
    protected HardwareMap hardwareMap;
    protected Gamepad gamepad;
    public StateBase(HardwareMap hardwareMap, Gamepad gamepad) {
        this.hardwareMap = hardwareMap;
        this.gamepad = gamepad;
    }
}
