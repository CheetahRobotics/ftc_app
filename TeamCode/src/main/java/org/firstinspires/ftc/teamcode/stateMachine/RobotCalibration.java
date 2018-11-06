package org.firstinspires.ftc.teamcode.stateMachine;

public class RobotCalibration {
    private double wheelCircumfrenceInches;
    private int countsPerRevolution;
    private int countsFor90DegreeTurn;
    public RobotCalibration(double wheelCircumfrenceInches, int countsPerRevolution, int countsFor90DegreeTurn) {
        this.wheelCircumfrenceInches = wheelCircumfrenceInches;
        this.countsPerRevolution = countsPerRevolution;
        this.countsFor90DegreeTurn = countsFor90DegreeTurn;
    }
    public int getCounts(double inches) {
        return (int) (this.countsPerRevolution * inches/this.wheelCircumfrenceInches);
    }
    public int getCountsFor90DegreeTurn() { return this.countsFor90DegreeTurn; }
}
