package com.hellofresh.driverUtil;

import com.hellofresh.exceptions.ScriptException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

/**
 * Handles the creation of webDriver based on selected browser
 *
 * @author Nilanthi
 * @since 21/11/2018
 */
public class DriverFactory {

    private static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
    private static ThreadLocal<String> browser = new ThreadLocal<String>();

    private DriverFactory() {

    }

    public static RemoteWebDriver createDriverInstance(String browserType) throws ScriptException {
        driver.set(getSpecificDriverInstance(browserType));
        browser.set(browserType);
        return driver.get();
    }

    /**
     * Create the webdriver instance based on the browser tyoe
     * @param browserType Type of the browser against which tests should be executed.
     *                    Example, chrome, firefox etc.
     * @return remote webdriver
     * @throws ScriptException
     */
    private static RemoteWebDriver getSpecificDriverInstance(String browserType) throws ScriptException {

        if (browserType.equalsIgnoreCase("chrome")) {
            URL driverPath = DriverFactory.class.getClassLoader().getResource("drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", driverPath.getPath());
            return new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            URL driverPath = DriverFactory.class.getClassLoader().getResource("drivers/geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", driverPath.getPath());
            return new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("ie")) {
            URL driverPath = DriverFactory.class.getClassLoader().getResource("drivers/IEDriverServer.exe");
            System.setProperty("webdriver.ie.driver", driverPath.getPath());
            return new InternetExplorerDriver();
        } else {
            throw new ScriptException("Invalid browser type. Valid types are: chrome, firefox, ie");
        }
    }

    /**
     * Returns the browser instance
     * @return
     */
    public static RemoteWebDriver getDriver() {
        return driver.get();
    }

    /**
     * Returns the browser type
     * @return
     */
    public static String getBrowser() {
        return browser.get();
    }

}
