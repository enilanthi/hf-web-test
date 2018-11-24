package com.hellofresh.base;

import com.hellofresh.exceptions.ScriptException;
import com.hellofresh.listeners.TestNGListener;
import com.hellofresh.driverUtil.DriverFactory;
import com.hellofresh.util.ExtentReportCreator;
import com.hellofresh.driverUtil.LocalDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void testSetup(){
        ExtentReportCreator.startReport();
    }

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(String browser) throws ScriptException {
        WebDriver driver = DriverFactory.createDriverInstance(browser);

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("http://automationpractice.com/index.php");
        driver.get("https://www.google.co.uk/");

        LocalDriverManager.setWebDriver(driver);
    }

    @AfterMethod
    public void tearDown(){
        ExtentReportCreator.getResult(TestNGListener.getCurrentResults());

        WebDriver driver = LocalDriverManager.getDriver();
        if (driver != null) {
            driver.close();
//            driver.quit();
        }
    }

    @AfterTest
    public void testTearDown(){
        ExtentReportCreator.endReport();
    }

}
