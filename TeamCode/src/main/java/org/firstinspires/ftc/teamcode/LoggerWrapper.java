package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.RobotLog;

public class LoggerWrapper {
    private static final String TAG = "LoggerWrapper";
    public enum LogLevel {None, Some, Verbose, VerboseWithTelemetry}
    public static LogLevel logLevel = LogLevel.Verbose;
    
    public static void log(String tag, String label, boolean args) {
        if (logLevel == LogLevel.Verbose) {
            RobotLog.ii(tag, "----> %s: %b", label, args);
        }
    }
    public static void log(String tag, String label, float args) {
        if (logLevel == LogLevel.Verbose) {
            RobotLog.ii(tag, "----> %s: %f", label, args);
        }
    }
    public static void log(String tag, String format, Object... args) {
        if (logLevel == LogLevel.Verbose) {
            RobotLog.ii(tag, format, args);
        }
    }
}
