# FTC Robotics State Machine Framework #

The files in this directory support a simple state machine framework for use with the ftc_app.

## Quick Start ##

What you want to do is create an OpMode. The OpMode is very simple. 
It just lists the sensors you care about, and declares the states in your state machine.
Something like:

```java
package org.firstinspires.ftc.teamcode.teleop;
   
@TeleOp(name = "TeleOpMode", group = "Linear Opmode")
public class TeleOpMode extends OpModeBase {
   
    @Override
    public void setupStates(StateMachine stateMachine) {
        stateMachine.registerTouchSensor("touch_sensor");
        stateMachine.addNewState(1, new State1(stateMachine));
        stateMachine.addNewState(2, new State2(stateMachine));
        stateMachine.addNewState(3, new State3(stateMachine));
        stateMachine.updateState(1);    // Start at state number 1.
    }

}

```

That's it. We've registered our one touch sensor and declared the 3 states in our state machine. I called them
State1, State2, and State3, but you can call them anything you want.

Now you need to create 3 classes corresponding to the 3 states above. 

```java
package org.firstinspires.ftc.teamcode.teleop;

import org.firstinspires.ftc.teamcode.stateMachine.StateBase;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;

import static org.firstinspires.ftc.teamcode.stateMachine.LoggerWrapper.log;

public class State3 extends StateBase {
    State3(StateMachine stateMachine) {
        super(stateMachine);
    }

    public void dpadUpChanged(boolean dpad_up) {
        if (dpad_up)
            
            stateMachine.updateState(1);
    }


    public void dpadDownChanged(boolean dpad_down) {
        if (dpad_down)
            stateMachine.updateState(2);

    }
    public void postEventsCallback() {
        // so something useful like drive.
    }
}

```

#### A few things to note for the State classes:
* They must extend `StateBase`.
* There must be a constructor with the line `super(stateMachine);` as its first line.
* Then you declare callbacks for any event you wish to handle.
* Any other non-event driven code should go in `postEventsCallback()`. This is normally where
you'd put driving code for instance. (You could do driving in an event-driven manner too, but that
seems a little complicated).
* You change state by calling `stateMachine.updateState(blah)` where `blah` is the new state 
you wish to transition to. 

There are 3 kinds of events that your state can handle:
1. Gamepad events. See the class [GamepadListenerBase](GamepadListenerBase.java) for a list of the possible events.
1. Sensor events. See the class [StateBase](StateBase.java) for their signatures. 
This is what the touch sensor looks like (currently the only sensor implemented):
    ```
    public void touchSensorCallback(String key, TouchSensor value) {
    }
    ```
1. Time events. This is the signature:
    ```
    protected void timeUpdate(double sinceOpModePlay, double sinceStateStart) {
        // sinceStateStart is reset to zero every time the state changes.
    }
    ```

#### Other conveniences:

Telemetry in event driven systems can be a pain. So this logic has been wrapped
and we have a simple way to do it: Simply call `addTelemetry()`:

```
protected void addTelemetry(String caption, String format, Object ...args) {
}
```
So for example: `addTelemetry("Motor", "Driving forward")`:

The message persists for the life of the state.


#### FAQ:
- Q: How do I access the hardware map in my state?   
A: `hardwareMap` is a variable you inherit from `StateBase`.

- Q: How do I access the gamepad in my state?   
A: `gamepad` is a variable you inherit from `StateBase`.



