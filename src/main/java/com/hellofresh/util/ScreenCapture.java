package com.hellofresh.util;

import com.hellofresh.driverUtil.DriverFactory;
import com.hellofresh.exceptions.TestAutomationException;
import com.hellofresh.listeners.TestNGListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

public class ScreenCapture {

    public static String getScreenshotPath() {
        URL inputStream = ScreenCapture.class.getProtectionDomain().getCodeSource().getLocation();
        return inputStream.getPath() + "../screenshots/browser/";
    }

    public static String getImgFileName() {
        return TestNGListener.getCurrentTest() + "_" + DriverFactory.getBrowser() + ".png";
    }

    public static void captureScreenshot() throws TestAutomationException {

        String path = getScreenshotPath();

        try {
            new File(path).mkdirs();
            FileOutputStream out = new FileOutputStream(path + "/" + getImgFileName());
            WebDriver driver = DriverFactory.getDriver();
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (Exception e) {
            throw new TestAutomationException(e.getMessage());
        }
    }
}
