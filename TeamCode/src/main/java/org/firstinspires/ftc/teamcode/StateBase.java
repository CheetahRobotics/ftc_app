package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.RobotLog;

import static org.firstinspires.ftc.teamcode.LoggerWrapper.log;


public class StateBase extends GamepadListenerBase {
    protected StateMachine stateMachine;
    protected HardwareMap hardwareMap;
    private GamepadWrapper gamepadWrapper;
    public String stateName;

    public StateBase() {
    }
    // TODO: find a way to put this in the constructor so can declare final.
    public void init(StateMachine stateMachine, HardwareMap hardwareMap, GamepadWrapper gamepadWrapper, String stateName) {
        this.stateMachine = stateMachine;
        this.hardwareMap = hardwareMap;
        this.gamepadWrapper = gamepadWrapper;
        this.stateName = stateName;
    }

    public void log(String label, boolean args) {
        LoggerWrapper.log(stateName, label, args);
    }

    public void log(String label, float args) {
        LoggerWrapper.log(stateName, label, args);
    }

    public void log(String format, Object... args) {
        LoggerWrapper.log(stateName, format, args);
    }

}
