package org.firstinspires.ftc.teamcode.stateMachine;

public class RobotCalibration {
    public final double wheelCircumfrenceInches;
    public final int countsPerRevolution;
    public final int countsFor90DegreeTurn;
    public RobotCalibration(double wheelCircumfrenceInches, int countsPerRevolution, int countsFor90DegreeTurn) {
        this.wheelCircumfrenceInches = wheelCircumfrenceInches;
        this.countsPerRevolution = countsPerRevolution;
        this.countsFor90DegreeTurn = countsFor90DegreeTurn;
    }
    public int getCounts(double inches) {
        return (int) (this.countsPerRevolution * inches/this.wheelCircumfrenceInches);
    }
}
