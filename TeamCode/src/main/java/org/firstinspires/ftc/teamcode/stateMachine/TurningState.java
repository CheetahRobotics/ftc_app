package org.firstinspires.ftc.teamcode.stateMachine;

public class TurningState extends DrivingState{

    public TurningState(StateMachine stateMachine,
                        Class<? extends StateBase> nextState,
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

        if (Math.abs(leftDrive.getCurrentPosition()) > stateMachine.getRobotCalibration().getCountsFor90DegreeTurn() ||
            Math.abs(rightDrive.getCurrentPosition()) > stateMachine.getRobotCalibration().getCountsFor90DegreeTurn()) {
            addTelemetry("Left Motor Pos: ", "%d", leftDrive.getCurrentPosition());
            addTelemetry("Right Motor Pos: ", "%d", rightDrive.getCurrentPosition());
            stopMotors();
            sleep(1000);
            stateMachine.updateState(this.nextState);
        }
    }
}
