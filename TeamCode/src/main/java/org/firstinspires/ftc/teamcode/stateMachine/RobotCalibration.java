package org.firstinspires.ftc.teamcode.stateMachine;

public class RobotCalibration {
    private double wheelCircumfrenceInches;
    private int countsPerRevolution;
    public RobotCalibration(double wheelCircumfrenceInches, int countsPerRevolution) {
        this.wheelCircumfrenceInches = wheelCircumfrenceInches;
        this.countsPerRevolution = countsPerRevolution;
    }
    public int getCounts(double inches) {
        return (int) (this.countsPerRevolution * inches/this.wheelCircumfrenceInches);
    }
}
