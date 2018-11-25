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

/**
 * Generate screenshots of the web application under test
 *
 * @author Nilanthi
 * @since 21/11/2018
 */
public class ScreenCapture {

    /**
     * Returns the path under which the screenshot will be generated
     * @return
     */
    public static String getScreenshotPath() {
        URL inputStream = ScreenCapture.class.getProtectionDomain().getCodeSource().getLocation();
        return inputStream.getPath() + "../screenshots/browser/";
    }

    /**
     * Returns the name of the image file (screenshot)
     * @return
     */
    public static String getImgFileName() {
        return TestNGListener.getCurrentTest() + "_" + DriverFactory.getBrowser() + ".png";
    }

    /**
     * Takes the screen capture
     * @throws TestAutomationException
     */
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
