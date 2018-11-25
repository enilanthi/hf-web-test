package com.hellofresh.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.hellofresh.listeners.TestNGListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;

/**
 * Handles all report creation related functionality using the 3rd party library ExtentReport
 *
 * @author Nilanthi
 * @since 21/11/2018
 */
public class ExtentReportCreator {

    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> logger = new ThreadLocal<ExtentTest>();

    /**
     * Sets all necessary configurations for the report
     */
    public static void startReport(){

        URL inputStream = ExtentReportCreator.class.getProtectionDomain().getCodeSource().getLocation();
        String path = inputStream.getPath()+"../extent-reports/test-output";
        new File(path).mkdirs();

        htmlReporter = new ExtentHtmlReporter(path+"/STMExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Environment", "Automation Testing");

        htmlReporter.config().setDocumentTitle("HF Web Test Results");
        htmlReporter.config().setReportName("HelloFresh Web Tests Results");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
    }

    public static ExtentTest initializeLogger(){
        logger.set(extent.createTest(TestNGListener.getCurrentTest()));
        return logger.get();
    }

    /**
     * Logs the end results of a test case in report
     * @param result
     */
    public static void getResult(ITestResult result){

        if(result.getStatus() == ITestResult.SUCCESS){
            logger.get().log(Status.PASS, MarkupHelper.createLabel(result.getName()+" - Test Case Passed", ExtentColor.GREEN));

        } else if(result.getStatus() == ITestResult.FAILURE){
                logger.get().log(Status.FAIL, MarkupHelper.createLabel(
                        result.getName()+" - Test Case Failed<br/>"+
                        "Error: "+result.getThrowable().getMessage(), ExtentColor.RED));
            try {
                String path = ScreenCapture.getScreenshotPath()+ScreenCapture.getImgFileName();
                logger.get().log(Status.INFO, "Screen capture:", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else if(result.getStatus() == ITestResult.SKIP){
            logger.get().log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
        }
    }

    /**
     * Flush ExtentReports content
     */
    public static void endReport(){
        extent.flush();
    }

    /**
     * Returns ExtentTest instance
     * @return
     */
    public static ExtentTest getLogger(){
        return logger.get();
    }
}
