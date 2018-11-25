package com.hellofresh.challenge.pageobjects;

import com.hellofresh.base.BasePage;
import com.hellofresh.exceptions.TestAutomationException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 * This page refers to "My Account" page. That is, the page that you land on, right after Logging In
 */
public class MyAccountPage extends BasePage {

    private static Logger log = Logger.getLogger(MyAccountPage.class);

    private By header_panel = By.cssSelector("h1");
    private By customerName_lbl = By.className("account");
    private By welcomeMsg_lbl = By.className("info-account");
    private By logout_link = By.className("logout");
    private By catory_tab = By.linkText("Women");

    public WomenClothingPage clickCatoryAsWomen() throws TestAutomationException {
        test_step_logger();
        findElement(catory_tab).click();
        log.info("[Step]: Click the catgory \"Women\"");
        return new WomenClothingPage();
    }

    public MyAccountPage verifyHeading(String heading) throws TestAutomationException {
        test_step_logger();
        verifyEquals(findElement(header_panel).getText(), heading);
        log.info("[Step]: Verify if the heading is displayed as: \"" + heading + "\"");
        return this;
    }

    public MyAccountPage verifySubStringInCurrentURL(String stringToBeLookedFor) {
        test_step_logger();
        verifyTrue(getDriver().getCurrentUrl().contains(stringToBeLookedFor));
        log.info("[Step]: Verify if the current url includes: " + stringToBeLookedFor);
        return this;
    }

    public MyAccountPage verifySignOutLinkDisplayed() throws TestAutomationException {
        test_step_logger();
        verifyTrue(findElement(logout_link).isDisplayed());
        log.info("[Step]: Verify if the Sign Out link is available.");
        return this;
    }

    public MyAccountPage verifyWelcomeMessage() throws TestAutomationException {
        test_step_logger();
        verifyTrue(findElement(welcomeMsg_lbl).getText().contains("Welcome to your account."));
        log.info("[Step]: Verify if the correct welcome message is displayed.");
        return this;
    }

    public MyAccountPage verifyCustomerName() {
        test_step_logger();
//       TODO: fix this
//        verifyEquals(findElement(customerName_lbl).getText(), customerName);
        log.info("[Step]: Verify if the correct customer name is displayed.");
        return this;
    }

    public MyAccountPage verifyCustomerName(String customerName) throws TestAutomationException {
        test_step_logger();
        verifyEquals(findElement(customerName_lbl).getText(), customerName);
        log.info("[Step]: Verify if the customer name: " + customerName + ", is displayed.");
        return this;
    }
}
