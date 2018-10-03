package org.firstinspires.ftc.teamcode.stateMachine;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.HashMap;
import java.util.Map;

import static org.firstinspires.ftc.teamcode.stateMachine.LoggerWrapper.log;

public class StateMachine {

    private static final String TAG = "StateMachine";
    private final Map<Integer, StateBase> states = new HashMap<>();

    private int currentStateNumber;
    private StateBase currentState;
    private String currentTag;

    final GamepadWrapper gamepadWrapper;
    final HardwareMap hardwareMap;
    final Telemetry telemetry;
    final ElapsedTime runtime;

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
        gamepadWrapper.updateGamepadListener((GamepadListener) currentState);
        log(TAG, currentStateAsString());
    }

    public void addNewState(int stateNumber, StateBase state) {
        if (states.containsKey(stateNumber))
            throw new RuntimeException("That state is already in the map! Can't add it twice");

        states.put(stateNumber, state);
    }

    public void preEventsCallback() {
        currentState.preEventsCallback();
    }

    public void postEventsCallback() {
        currentState.timeUpdate(runtime.seconds(), runtime.seconds()-currentState.getStartTime());

        currentState.postEventsCallback();
        currentState.updateTelemetry(telemetry);
    }
}
