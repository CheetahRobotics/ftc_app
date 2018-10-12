package org.firstinspires.ftc.teamcode.stateMachine;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.firstinspires.ftc.teamcode.stateMachine.LoggerWrapper.log;

public class StateMachine {

    private static final String TAG = "StateMachine";
    private final Map<Integer, StateBase> states = new HashMap<>();

    private int currentStateNumber;
    private StateBase currentState;
    private String currentTag;

    private final GamepadWrapper gamepadWrapper;
    final HardwareMap hardwareMap;
    private final Telemetry telemetry;
    private final ElapsedTime runtime;
    private final Set<String> allStates = new HashSet<>();
    private Gamepad gamepad;

    public StateMachine(
            HardwareMap hardwareMap,
            GamepadWrapper gamepadWrapper,
            Telemetry telemetry,
            ElapsedTime runtime) {
        this.gamepadWrapper = gamepadWrapper;
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;
        this.runtime = runtime;
    }

    public final String currentStateAsString() {
        return String.format("%d, %s", currentStateNumber, currentState.stateName);
    }

    public void updateState(int stateNumber) {
        if (!states.containsKey(stateNumber))
            throw new RuntimeException("That state is not in the map!");
        currentState = states.get(stateNumber);
        currentState.youveBeenStarted(runtime.seconds());
        currentStateNumber = stateNumber;
        gamepadWrapper.updateGamepadListener(currentState);
        log(TAG, currentStateAsString());
    }

    public void addNewState(int stateNumber, StateBase state) {
        if (states.containsKey(stateNumber))
            throw new RuntimeException("That state number is already in the map! Can't add it twice");
        if (allStates.contains(state.getClass().getSimpleName()))
            throw new RuntimeException("Can't have the same state class in the map twice.");
        states.put(stateNumber, state);
        allStates.add(state.getClass().getSimpleName());
    }

    void preEventsCallback() {
        currentState.preEventsCallback();
    }

    void postEventsCallback() {
        currentState.timeUpdate(runtime.seconds(), runtime.seconds()-currentState.getStartTime());

        currentState.postEventsCallback();
        currentState.updateTelemetry(telemetry);
    }
    private final Map<String, TouchSensor> touchSensorMap = new HashMap<>();
    public void registerTouchSensor(String name) {
        touchSensorMap.put(name, hardwareMap.touchSensor.get(name));
    }

    public void doSensorCallbacks() {
        for (Map.Entry<String, TouchSensor> entry : touchSensorMap.entrySet())
            currentState.touchSensorCallback(entry.getKey(), entry.getValue());
    }

    void setGamepad(Gamepad gamepad) {
        currentState.setGamepad(gamepad);
    }
}
