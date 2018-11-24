package com.hellofresh.base;

import com.github.javafaker.Faker;
import com.hellofresh.exceptions.ApplicationException;
import com.hellofresh.exceptions.TestAutomationException;
import com.hellofresh.exceptions.UnhandledException;
import com.hellofresh.util.DriverFactory;
import com.hellofresh.util.ExtentReportCreator;
import com.hellofresh.util.ScreenCapture;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {

    //    TODO: add comments
    protected static Faker faker = new Faker();

    protected WebElement findElement(By findBy) throws TestAutomationException {
        try {
            WebDriver driver = DriverFactory.getDriver();
            return (new WebDriverWait(driver, 5)).until(ExpectedConditions.elementToBeClickable(findBy));
        } catch (NoSuchElementException e) {
            throw new ApplicationException(e.getMessage());
        } catch (TimeoutException e) {
            throw new ApplicationException(e.getMessage());
        } catch (Exception e) {
            throw new UnhandledException(e.getMessage());
        }
    }

    public void verifyEquals(String actual, String expected, String message) {
        try {
            Assert.assertEquals(actual, expected);
        } catch (AssertionError e) {
            handleAssertionFailure(e.getMessage());
        }
    }

    public void verifyTrue(boolean condition, String message) {
        try {
            Assert.assertTrue(condition);
        } catch (AssertionError e) {
            handleAssertionFailure(e.getMessage());
        }
    }

    private void handleAssertionFailure(String message) {
        try {
//            TODO verify this
            ScreenCapture.captureScreenshot();
            Assert.fail(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void test_step_logger() {
        ExtentReportCreator.getLogger().info("[Step]: " +
                Thread.currentThread().getStackTrace()[2].getFileName() + "#" +
                Thread.currentThread().getStackTrace()[2].getMethodName());
    }
}
