package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.HashMap;
import java.util.Map;

import static org.firstinspires.ftc.teamcode.LoggerWrapper.log;

public class StateMachine {

    private static final String TAG = "StateMachine";
    private final Map<Integer, StateBase> states = new HashMap<>();

    private int currentStateNumber;
    private StateBase currentState;
    private String currentTag;

    private final GamepadWrapper gamepadWrapper;
    private final HardwareMap hardwareMap;
    private final Telemetry telemetry;
    public StateMachine(HardwareMap hardwareMap, GamepadWrapper gamepadWrapper, Telemetry telemetry) {
        this.gamepadWrapper = gamepadWrapper;
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;
    }
    public final String currentStateAsString() {
        return String.format("%d, %s", currentStateNumber, currentState.stateName);
    }
    public void updateState(int stateNumber) {
        if (!states.containsKey(stateNumber))
            throw new RuntimeException("That state is not in the map!");
        currentState = states.get(stateNumber);
        currentStateNumber = stateNumber;
        gamepadWrapper.updateGamepadListener((GamepadListener) currentState);
        log(TAG, currentStateAsString());
    }

    public void addNewState(int stateNumber, StateBase state) {
        if (states.containsKey(stateNumber))
            throw new RuntimeException("That state is already in the map! Can't add it twice");

        state.init(this, hardwareMap, gamepadWrapper, state.getClass().getSimpleName());
        states.put(stateNumber, state);
    }

}
