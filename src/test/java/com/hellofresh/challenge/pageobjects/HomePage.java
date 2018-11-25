package com.hellofresh.challenge.pageobjects;

import com.hellofresh.base.BasePage;
import com.hellofresh.exceptions.TestAutomationException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 * This page refers to the home page of the application.
 * That is, the page that you reach by entering http://automationpractice.com/index.php
 */
public class HomePage extends BasePage {

    private static Logger log = Logger.getLogger(HomePage.class);

    private By signIn_Link = By.className("login");

    public SignInPage homePage_clickSignIn() throws TestAutomationException {
        test_step_logger();
        findElement(signIn_Link).click();
        log.info("[Step]: Click \"Sign In\" on Home Page");
        return new SignInPage();
    }
}
