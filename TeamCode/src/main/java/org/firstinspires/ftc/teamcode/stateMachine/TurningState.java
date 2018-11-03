package org.firstinspires.ftc.teamcode.stateMachine;

public class TurningState extends DrivingState{

    public TurningState(StateMachine stateMachine,
                        Class<? extends StateBase> nextState,
                        boolean isLeftTurn){
        super(
                stateMachine,
                1.0,
                nextState,
                isLeftTurn ? .5 : 0,
                isLeftTurn ? 0 : .5
        );
    }
    public TurningState(StateMachine stateMachine,
                        Class<? extends StateBase> nextState,
                        double degreesToTurn,
                        boolean isLeftTurn){
        super(
                stateMachine,
                nextState,
                isLeftTurn ? 0 : -.5 ,
                isLeftTurn ? .5 : 0
        );
    }
    @Override
    public void postEventsCallback() {
        super.postEventsCallback();

        addTelemetry("Left Motor Pos: ", "%d", leftDrive.getCurrentPosition());
        addTelemetry("Right Motor Pos: ", "%d", rightDrive.getCurrentPosition());

        if (Math.abs(leftDrive.getCurrentPosition()) > 440.64 ||
            Math.abs(rightDrive.getCurrentPosition()) > 440.64) {
            addTelemetry("Left Motor Pos: ", "%d", leftDrive.getCurrentPosition());
            addTelemetry("Right Motor Pos: ", "%d", rightDrive.getCurrentPosition());
            stopMotors();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stateMachine.updateState(this.nextState);
        }
    }
}
