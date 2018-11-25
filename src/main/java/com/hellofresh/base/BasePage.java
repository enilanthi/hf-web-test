package com.hellofresh.base;

import com.github.javafaker.Faker;
import com.hellofresh.exceptions.ApplicationException;
import com.hellofresh.exceptions.TestAutomationException;
import com.hellofresh.exceptions.UnhandledException;
import com.hellofresh.driverUtil.DriverFactory;
import com.hellofresh.util.ExtentReportCreator;
import com.hellofresh.util.ScreenCapture;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * This class handles the webelements gracefuly and delegate assertion methods for page objects class.
 * All Page object classes need to extended this class.
 *
 * @author Nilanthi
 * @since 21/11/2018
 */
public class BasePage {

    protected static Faker faker = new Faker();

    /**
     * Finds the element that matches the given criteria
     * @param findBy the locator strategy used to identify the component
     * @return Web element that matched
     */
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

    /**
     * Asserts that the two Strings are equal.
     * @param actual actual value
     * @param expected expected value
     */
    protected void verifyEquals(String actual, String expected) {
        try {
            Assert.assertEquals(actual, expected);
        } catch (AssertionError e) {
            handleAssertionFailure(e.getMessage());
        }
    }

    /**
     * Asserts that the given condition is true
     * @param condition the condition to be checked
     */
    protected void verifyTrue(boolean condition) {
        try {
            Assert.assertTrue(condition);
        } catch (AssertionError e) {
            handleAssertionFailure(e.getMessage());
        }
    }

    private void handleAssertionFailure(String message) {
        try {
            ScreenCapture.captureScreenshot();
            Assert.fail(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Track page-objects steps and share with extent report
     */
    protected void test_step_logger() {
        ExtentReportCreator.getLogger().info("[Step]: " +
                Thread.currentThread().getStackTrace()[2].getFileName() + "#" +
                Thread.currentThread().getStackTrace()[2].getMethodName());
    }
}
