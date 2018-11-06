package org.firstinspires.ftc.teamcode.stateMachine;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.Map;
import java.util.TreeMap;

import static org.firstinspires.ftc.teamcode.stateMachine.LoggerWrapper.log;


public abstract class StateBase extends GamepadListenerBase {
    protected final StateMachine stateMachine;
    protected final HardwareMap hardwareMap;
    protected final String stateName;
    private final Map<String, String> telemetryData = new TreeMap<>();
    private double startTime;
    protected Gamepad gamepad;

    protected StateBase(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
        this.hardwareMap = stateMachine.hardwareMap;
        this.stateName = this.getClass().getSimpleName();
    }
    void setGamepad(Gamepad gamepad) {
        this.gamepad = gamepad;
    }

    // ==== logging ====
    protected void log(String label, boolean args) {
        LoggerWrapper.log(stateName, label, args);
    }

    protected void log(String label, float args) {
        LoggerWrapper.log(stateName, label, args);
    }

    protected void log(String format, Object... args) {
        LoggerWrapper.log(stateName, format, args);
    }

    // ==== telemetry ====
    protected void addTelemetry(String caption, String format, Object ...args) {
        telemetryData.put(caption, String.format(format, args));
    }
    protected void clearTelemetry(String caption) {
        telemetryData.remove(caption);
    }
    protected void clearAllTelemetry() {
        telemetryData.clear();
    }
    void updateTelemetry(Telemetry telemetry) {
        for (Map.Entry<String, String> entry : telemetryData.entrySet()) {
            telemetry.addData(entry.getKey(), entry.getValue());
        }
    }
    // ==== time management ====
    protected void timeUpdate(double sinceOpModePlay, double sinceStateStart) {

    }
    void startTimerForNewState(double elapsedSeconds) {
        startTime = elapsedSeconds;
    }
    double getStartTime() { return startTime; }

    // ==== life cycle management ====

    protected void preEventsCallback() {
    }

    protected void postEventsCallback() {
    }

    // ==== Sensor management ====
    // TODO: implement more sensor callbacks.

    public void touchSensorCallback(String key, TouchSensor value) {
    }

    // === Helper functions to make state code cleaner. ===
    protected void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
