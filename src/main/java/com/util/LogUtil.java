package com.util;

import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogUtil {

    // Log4j logger instance
    private static final Logger log = LogManager.getLogger(LogUtil.class);

    // ExtentTest instance for ExtentReports (make sure this is initialized elsewhere)
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    // Method to set the ExtentTest instance (used in Listeners)
    public static void setExtentTest(ExtentTest test) {
        extentTest.set(test);
    }

    // Common logging method that logs to both Log4j and ExtentReports
    public static void info(String message) {
        // Log message to Log4j
        log.info(message);

        // Log message to ExtentReports
        if (extentTest.get() != null) {
            extentTest.get().info(message);
        }
    }

    public static void warn(String message) {
        log.warn(message);
        if (extentTest.get() != null) {
            extentTest.get().warning(message);
        }
    }

    public static void error(String message, Throwable t) {
        log.error(message, t);
        if (extentTest.get() != null) {
            extentTest.get().fail(message).fail(t);
        }
    }

    // Add more methods for other log levels if needed (debug, fatal, etc.)
}
