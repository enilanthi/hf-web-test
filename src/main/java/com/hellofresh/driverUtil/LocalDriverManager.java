package com.hellofresh.driverUtil;

import org.openqa.selenium.WebDriver;

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
}
