package com.hellofresh.listeners;

import com.hellofresh.driverUtil.DriverFactory;
import com.hellofresh.util.ExtentReportCreator;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {

    private final static Logger log = Logger.getLogger(TestNGListener.class);
    private static ThreadLocal<String> currentTest = new ThreadLocal<String>();
    private static ThreadLocal<ITestResult> currentResults = new ThreadLocal<ITestResult>();

    public void onTestStart(ITestResult iTestResult) {
        log.info("[Test Starting] : " + getMethodName(iTestResult));
        currentTest.set(getMethodName(iTestResult) + "_" + DriverFactory.getBrowser());
        ExtentReportCreator.initializeLogger();
    }

    public void onTestSuccess(ITestResult iTestResult) {
        log.info("[Test Passed] : " + getMethodName(iTestResult));
        currentResults.set(iTestResult);
    }

    public void onTestFailure(ITestResult iTestResult) {
        log.info("[Test Failed] : " + getMethodName(iTestResult));
        currentResults.set(iTestResult);
    }

    public void onTestSkipped(ITestResult iTestResult) {
        log.info("[Test Skipped] : " + getMethodName(iTestResult));
        currentResults.set(iTestResult);
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {
        log.info("--- All Test Execution Started ---");
    }

    public void onFinish(ITestContext iTestContext) {
        log.info("--- All Test Finished ---");
    }

    private static String getMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    public static ITestResult getCurrentResults() {
        return currentResults.get();
    }

    public static String getCurrentTest() {
        return currentTest.get();
    }

}
