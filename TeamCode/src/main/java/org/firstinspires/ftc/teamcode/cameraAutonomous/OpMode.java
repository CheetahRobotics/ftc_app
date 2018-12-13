package org.firstinspires.ftc.teamcode.cameraAutonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.stateMachine.GamepadWrapper;
import org.firstinspires.ftc.teamcode.stateMachine.OpModeBase;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.KeyPoint;
import org.opencv.core.Mat;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import java.util.List;

import static org.opencv.imgproc.Imgproc.circle;

@Autonomous(name = "CameraAutonomousOpMode", group = "Linear Opmode")
public class OpMode extends OpModeBase implements CameraBridgeViewBase.CvCameraViewListener2 {
    private GripPipeline gripPipeline = new GripPipeline();
    private int viewMode = 0;
    private float H = 95;
    private Point centerOfBiggestBlob = new Point(0,0);

    @Override
    public void beforeLoop() {
        startOpenCV(this);
    }

    @Override
    public void afterLoop() {
        stopOpenCV();
    }

    @Override
    public void onCameraViewStarted(int width, int height) {
    }

    @Override
    public void onCameraViewStopped() {
    }

    @Override
    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
        // This is where the magic will happen. inputFrame has all the data for each camera frame.
        Mat mRgba = inputFrame.rgba();

        gripPipeline.process(mRgba, this.H);

        switch (this.viewMode) {
            case 0:
                stateMachine.currentState().addTelemetry("cv","cameraOutput");
                break;
            case 1:
                mRgba = gripPipeline.hslThresholdOutput();
                stateMachine.currentState().addTelemetry("cv","hslThresholdOutput");
                break;
            case 2:
                mRgba = gripPipeline.cvErodeOutput();
                stateMachine.currentState().addTelemetry("cv","cvErodeOutput");
                break;
            case 3:
                mRgba = gripPipeline.maskOutput();
                stateMachine.currentState().addTelemetry("cv","maskOutput");
                break;
            case 4:
                mRgba = gripPipeline.blurOutput();
                stateMachine.currentState().addTelemetry("cv","blurOutput");
                break;
        }


        centerOfBiggestBlob = drawCircleAroundContours(mRgba, gripPipeline.findBlobsOutput(), new Scalar(255, 255, 255));

        return mRgba;
    }
    private Point drawCircleAroundContours(Mat image, MatOfKeyPoint contours, Scalar color) {
        //For each contour found
        MatOfPoint2f approxCurve = new MatOfPoint2f();

        double maxArea = 0;
        KeyPoint maxRect = null;
        List<KeyPoint> blah = contours.toList();
        stateMachine.currentState().addTelemetry("CV", "N points = %d", blah.size());
        for (int i=0; i < blah.size(); i++)
        {
            Rect rect = Imgproc.boundingRect(new MatOfPoint(blah.get(i).pt));
            if (blah.get(i).size > maxArea) {
                maxArea = blah.get(i).size;
                maxRect = blah.get(i);
            }
            circle( image, blah.get(i).pt, (int) blah.get(i).size, color, 2, 8, 0 );
        }
        if (maxRect == null)
            return new Point(0.0,0.0);
        return maxRect.pt;
    }

    @Override
    public void initStateMachine(StateMachine stateMachine) {
        stateMachine.updateState(State1.class);    // Start at state number 1.
    }
    public void incrementView() {
        this.viewMode++;
        this.viewMode = this.viewMode%5;

    }
    public void incrementH(){
        this.H++;


    }
    public void decrementH(){
        this.H--;

    }

    public float getH() {
        return this.H;
    }


    public Point getCenterOfBiggestBlob() {
        return centerOfBiggestBlob;
    }
}
