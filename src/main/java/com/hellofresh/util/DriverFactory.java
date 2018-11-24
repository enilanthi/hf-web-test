package com.hellofresh.util;

import com.hellofresh.exceptions.ScriptException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class DriverFactory {

    private static RemoteWebDriver driver;
    private static String browser;

    private DriverFactory(){

    }

    public static RemoteWebDriver createDriverInstance(String browserType) throws ScriptException {
        if (driver==null || driver.getSessionId()==null){
            driver = getSpecificDriverInstance(browserType);
            browser = browserType;
        }

        return driver;
    }

    private static RemoteWebDriver getSpecificDriverInstance(String browserType) throws ScriptException {

        if (browserType.equalsIgnoreCase("chrome")) {
            URL driverPath = DriverFactory.class.getClassLoader().getResource("drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", driverPath.getPath());
            return new ChromeDriver();
        } else  if (browserType.equalsIgnoreCase("firefox")) {
            URL driverPath = DriverFactory.class.getClassLoader().getResource("drivers/geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", driverPath.getPath());
            return new FirefoxDriver();
        } else  if (browserType.equalsIgnoreCase("ie")) {
//            TODO: test this
            URL driverPath = DriverFactory.class.getClassLoader().getResource("drivers/IEDriverServer.exe");
            System.setProperty("webdriver.ie.driver", driverPath.getPath());
            return new InternetExplorerDriver();
        } else {
            throw new ScriptException("Invalid browser type. Valid types are: chrome, firefox, ie");
        }
    }

    public static RemoteWebDriver getDriver(){
        return driver;
    }

    public static String getBrowser(){
        return browser;
    }

}
