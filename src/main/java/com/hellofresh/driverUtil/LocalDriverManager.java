package com.hellofresh.driverUtil;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 * Manages the web driver instances
 *
 * @author Nilanthi
 * @since 23/11/2018
 */
public class LocalDriverManager {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    public static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }

    /**
     * Kill if any webdriver instances are still alive
     */
    public static void killWebDriverProcess() {
        try {
            Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f");
            Runtime.getRuntime().exec("taskkill /im geckodriver.exe /f");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
