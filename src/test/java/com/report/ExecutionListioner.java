package com.report;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.util.LogUtil;

public class ExecutionListioner implements ITestListener {

	private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    // This method initializes the ExtentReports
    public void onStart(ITestContext context) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/ExtentReport.html");
        sparkReporter.config().setReportName("Automation Test Report");
        sparkReporter.config().setDocumentTitle("Test Report");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Tester", "QA Engineer");
        extent.setSystemInfo("Environment", "Production");
    }

    // This method is invoked before each test
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
        LogUtil.setExtentTest(extentTest);

    }

    // This method is invoked when a test passes
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    // This method is invoked when a test fails
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());
    }

    // This method is invoked when a test is skipped
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test Skipped");
    }

    // This method is invoked when the entire test suite finishes
    public void onFinish(ITestContext context) {
        extent.flush();  // Writes all the logs to the report
    }
}
