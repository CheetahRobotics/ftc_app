package org.firstinspires.ftc.teamcode.stateMachine;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.firstinspires.ftc.teamcode.stateMachine.LoggerWrapper.log;

public class StateMachine {

    private static final String TAG = "StateMachine";

    private StateBase currentState;
    private String currentTag;

    private final GamepadWrapper gamepadWrapper;
    final HardwareMap hardwareMap;
    private final Telemetry telemetry;
    private final ElapsedTime runtime;
    private final OpMode opMode;
    private Gamepad gamepad;

    public StateMachine(
            HardwareMap hardwareMap,
            GamepadWrapper gamepadWrapper,
            Telemetry telemetry,
            ElapsedTime runtime,
            OpMode opMode) {
        this.gamepadWrapper = gamepadWrapper;
        this.hardwareMap = hardwareMap;
        this.telemetry = telemetry;
        this.runtime = runtime;
        this.opMode = opMode;
    }

    public final String currentStateAsString() {
        return String.format("%s", currentState.stateName);
    }
    public void stop() {
        this.opMode.stop();
    }

    public void updateState(Class<? extends StateBase> aState) {
        try {
            currentState = aState.getConstructor(StateMachine.class).newInstance(this);
        }
        catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new RuntimeException(
                    String.format("Can't start %s, make sure class and constructors are public!",
                            aState.getSimpleName()
                            ));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.toString());
        }
        currentState.startTimerForNewState(runtime.seconds());
        gamepadWrapper.updateGamepadListener(currentState);
        log(TAG, currentStateAsString());
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
