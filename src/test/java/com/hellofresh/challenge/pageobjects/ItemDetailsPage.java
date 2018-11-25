package com.hellofresh.challenge.pageobjects;

import com.hellofresh.base.BasePage;
import com.hellofresh.exceptions.TestAutomationException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 * This refers to the page that displays all details about a selected item
 */
public class ItemDetailsPage extends BasePage {

    private static Logger log = Logger.getLogger(ItemDetailsPage.class);

    private By addToCart_Btn = By.name("Submit");
    private By proceedToCheckout_btn = By.xpath("//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']");

    public ItemDetailsPage itemDetailsPage_clickAddToCartButton() throws TestAutomationException {
        test_step_logger();
        findElement(addToCart_Btn).click();
        log.info("[Step]: Click \"Add to cart\" button on item details page");
        return this;
    }

    public ShoppingCartSummaryPage itemDetailsPage_clickProceedToCheckoutButton() throws TestAutomationException {
        test_step_logger();
        waitUntilElementVisibleAndFind(proceedToCheckout_btn).click();
        log.info("[Step]: Click \"Procced to checkout\" button on item details page");
        return new ShoppingCartSummaryPage();
    }
}
