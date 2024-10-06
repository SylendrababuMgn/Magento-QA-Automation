package com.report;

import org.testng.Assert;

import com.util.LogUtil;

public class CustomAssert extends LogUtil{

    // Custom assert method to check equality with automatic logging
    public static void assertEquals(Object actual, Object expected, String message) {
        try {
            // Log expected and actual values in one line separated by ||
            LogUtil.info("Asserting - " + message + " || Expected: " + expected + " || Actual: " + actual);

            // TestNG assertion
            Assert.assertEquals(actual, expected);

            // If assertion passes, log success
            LogUtil.info("Assertion Passed: " + message);
        } catch (AssertionError e) {
            // If assertion fails, log failure
            LogUtil.error("Assertion Failed: " + message + " || Expected: " + expected + " || Actual: " + actual, e);
            throw e; // Re-throw the exception to fail the test
        }
    }

    // Custom assert method to check if a condition is true with automatic logging
    public static void assertTrue(boolean condition, String message) {
        try {
            // Log the condition as expected to be true
            LogUtil.info("Asserting - " + message + " || Expected: true || Actual: " + condition);

            // TestNG assertion
            Assert.assertTrue(condition);

            // If assertion passes, log success
            LogUtil.info("Assertion Passed: " + message);
        } catch (AssertionError e) {
            // If assertion fails, log failure
            LogUtil.error("Assertion Failed: " + message + " || Expected: true || Actual: " + condition, e);
            throw e; // Re-throw the exception to fail the test
        }
    }

    // Custom assert method to check if a condition is false with automatic logging
    public static void assertFalse(boolean condition, String message) {
        try {
            // Log the condition as expected to be false
            LogUtil.info("Asserting - " + message + " || Expected: false || Actual: " + condition);

            // TestNG assertion
            Assert.assertFalse(condition);

            // If assertion passes, log success
            LogUtil.info("Assertion Passed: " + message);
        } catch (AssertionError e) {
            // If assertion fails, log failure
            LogUtil.error("Assertion Failed: " + message + " || Expected: false || Actual: " + condition, e);
            throw e; // Re-throw the exception to fail the test
        }
    }
}
