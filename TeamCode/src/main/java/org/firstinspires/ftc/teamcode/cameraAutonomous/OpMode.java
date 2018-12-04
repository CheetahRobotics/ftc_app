package org.firstinspires.ftc.teamcode.cameraAutonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.stateMachine.GamepadWrapper;
import org.firstinspires.ftc.teamcode.stateMachine.OpModeBase;
import org.firstinspires.ftc.teamcode.stateMachine.StateMachine;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import java.util.List;

@Autonomous(name = "CameraAutonomousOpMode", group = "Linear Opmode")
public class OpMode extends OpModeBase implements CameraBridgeViewBase.CvCameraViewListener2 {
    private static final String TAG = "GamepadListenerBase";
    private Mat mRgba;
    private Mat mRgbaT;
    private Mat mRgbaRotated;
    private Scalar CONTOUR_COLOR;
    private ColorBlobDetector    mDetectorWhite;
    private ColorBlobDetector    mDetectorOrange;

    @Override
    public void beforeLoop() {
        startOpenCV(this);
    }

    @Override
    public void afterLoop() {
        stopOpenCV();
    }

    public void onCameraViewStarted(int width, int height) {
        mRgbaT = new Mat();
        mRgbaRotated = new Mat();
        CONTOUR_COLOR = new Scalar(0,255,0,255);
        mDetectorWhite = new ColorBlobDetector();
        mDetectorOrange = new ColorBlobDetector();
//        setWhiteColor(new Scalar(152.0, 61.0, 81.0, 255.0), true);
//        setOrangeColor(new Scalar(14.0, 52.0, 76.0, 255.0), true);
        setWhiteColor(new Scalar(252.0, 193.0, 114.0, 255.0), true);
        setOrangeColor(new Scalar(249.0, 219.0, 165.0, 255.0), true);
    }
    private void setWhiteColor(Scalar color, boolean persist) {
        Scalar mBlobColorHsv = convertScalarRgba2Hsv(color);
        mDetectorWhite.setHsvColor(mBlobColorHsv);
    }
    private void setOrangeColor(Scalar color, boolean persist) {
        Scalar mBlobColorHsv = convertScalarRgba2Hsv(color);
        mDetectorOrange.setHsvColor(mBlobColorHsv);
    }
    private Scalar convertScalarRgba2Hsv(Scalar rgbColor) {
        Mat pointMatRgba = new Mat(1, 1, CvType.CV_8UC3, rgbColor);
        Mat pointMatHsv = new Mat();
        Imgproc.cvtColor(pointMatRgba, pointMatHsv, Imgproc.COLOR_RGB2HSV_FULL, 4);

        return new Scalar(pointMatHsv.get(0, 0));
    }

    @Override
    public void onCameraViewStopped() {

    }

    @Override
    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
        // This is where the magic will happen. inputFrame has all the data for each camera frame.
        List<MatOfPoint> contours;

        mRgba = inputFrame.rgba();

        mDetectorWhite.process(mRgba);
        contours = mDetectorWhite.getContours();
        Imgproc.drawContours(mRgba, contours, -1, CONTOUR_COLOR);
        Point whiteCenter = drawRectangleAroundContours(mRgba, contours, new Scalar(255, 255, 255));

        mDetectorOrange.process(mRgba);
        contours = mDetectorOrange.getContours();
        Imgproc.drawContours(mRgba, contours, -1, CONTOUR_COLOR);
        Point orangeCenter = drawRectangleAroundContours(mRgba, contours,  new Scalar(250, 180, 0));

//        if ((orangeCenter.x == 0.0 && orangeCenter.y == 0.0) || (whiteCenter.x == 0.0 && whiteCenter.y == 0.0))
//            mBeaconCenterPointPixels = new Point(0.0, 0.0);
//        else
//            mBeaconCenterPointPixels = new Point((whiteCenter.x + orangeCenter.x)/2.0, (whiteCenter.y + orangeCenter.y)/2.0);
//        mBeaconCenterPointPercent = new Point(mBeaconCenterPointPixels.x/mRgba.width(), mBeaconCenterPointPixels.y/mRgba.height());
//        Imgproc.circle(mRgba, mBeaconCenterPointPixels, 10, new Scalar(255,255,100), 10);

        // OpenCv defaults to landscape on preview. This code rotates 90 degrees to portrait
//        Mat tempMat = mRgba.t();
//        Core.flip(tempMat, mRgbaT, 1);
//        Imgproc.resize(mRgbaT, mRgbaRotated, mRgba.size());
//        tempMat.release();
//        return mRgbaRotated;
        return mRgba;
    }
    private Point drawRectangleAroundContours(Mat image, List<MatOfPoint> contours, Scalar color) {
        //For each contour found
        MatOfPoint2f approxCurve = new MatOfPoint2f();

        double maxArea = 0;
        Rect maxRect = null;
        for (int i=0; i<contours.size(); i++)
        {
            //Convert contours(i) from MatOfPoint to MatOfPoint2f
            MatOfPoint2f contour2f = new MatOfPoint2f( contours.get(i).toArray() );
            //Processing on mMOP2f1 which is in type MatOfPoint2f
            double approxDistance = Imgproc.arcLength(contour2f, true)*0.02;
            Imgproc.approxPolyDP(contour2f, approxCurve, approxDistance, true);

            //Convert back to MatOfPoint
            MatOfPoint points = new MatOfPoint( approxCurve.toArray() );

            // Get bounding rect of contour
            Rect rect = Imgproc.boundingRect(points);
            if (rect.area() > maxArea) {
                maxArea = rect.area();
                maxRect = rect;
            }

            // draw enclosing rectangle (all same color, but you could use variable i to make them unique)
            Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), color);
            Imgproc.rectangle(image, new Point(rect.x-1, rect.y-1), new Point(rect.x+1 + rect.width, rect.y+1 + rect.height), color);
            Imgproc.rectangle(image, new Point(rect.x-2, rect.y-2), new Point(rect.x+2 + rect.width, rect.y+2 + rect.height), color);
        }
        if (maxRect == null)
            return new Point(0.0,0.0);
        return new Point(maxRect.x + maxRect.width/2.0, maxRect.y + maxRect.height/2.0);
    }

    @Override
    public void initStateMachine(StateMachine stateMachine) {
        stateMachine.updateState(State1.class);    // Start at state number 1.
    }

}
