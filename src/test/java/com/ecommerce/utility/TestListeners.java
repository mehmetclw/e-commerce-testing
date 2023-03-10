package com.ecommerce.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.time.LocalDateTime;

public class TestListeners implements ITestListener {
    private ExtentReports extent;
    private ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test Skipped");
    }


    @Override
    public void onStart(ITestContext context) {
        String date= String.valueOf(LocalDateTime.now());
        String fileName = "test-output/MyExtentReport"+date+".html";
        ExtentSparkReporter htmlReport = new ExtentSparkReporter(fileName);
        extent = new ExtentReports();
        extent.attachReporter(htmlReport);
        // Optional but nice to have - System information for HTML report
        extent.setSystemInfo("Environment", ConfigReader.getProperty("env"));
        extent.setSystemInfo("Browser", System.getProperty("browser") == null ? ConfigReader.getProperty("browser") : System.getProperty("browser"));
        extent.setSystemInfo("OS", System.getProperty("os.name"));
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
