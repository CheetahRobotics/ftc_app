package org.firstinspires.ftc.teamcode;

import java.util.HashMap;
import java.util.Map;

public class StateMachine {

    private static final String TAG = "AutonomousStateMachine";
    private final Map<Integer, State> states;
    private State currentState;
    private GamepadWrapper gamepadWrapper;
    public StateMachine(HashMap<Integer, State> states, GamepadWrapper gamepadWrapper) {
        this.states = states;
        this.gamepadWrapper = gamepadWrapper;
        this.updateState(1);
    }
    protected void updateState(int state) {
        currentState = states.get(state);   // #TODO: error handling.
        gamepadWrapper.updateGamepadListener((GamepadListener) currentState);
    }


}
