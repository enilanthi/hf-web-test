package com.hellofresh.challenge.pageobjects;

import com.hellofresh.base.BasePage;
import com.hellofresh.exceptions.TestAutomationException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 * This refers to the page, which displays all women clothing.
 */
public class WomenClothingPage extends BasePage {

    private static Logger log = Logger.getLogger(WomenClothingPage.class);

    By clothItem_div = By.xpath("//a[@title='Faded Short Sleeve T-shirts']/ancestor::li");

    public ItemDetailsPage clickShortSleeveTshirt() throws TestAutomationException {
        test_step_logger();
        findElement(clothItem_div).click();

        // In firefox, the following will display a popup
        if (!getBrowserType().equalsIgnoreCase("firefox")) {
            findElement(clothItem_div).click();
        }
        log.info("[Step]: Click \"Faded Short Sleeve T-shirts\"");
        return new ItemDetailsPage();
    }
}
