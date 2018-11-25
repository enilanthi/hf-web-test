package com.hellofresh.challenge.pageobjects;

import com.hellofresh.base.BasePage;
import com.hellofresh.exceptions.TestAutomationException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 * This refers to the page that displays shopping-cart summary while proceeding with checkout
 */
public class ShoppingCartSummaryPage extends BasePage {

    private static Logger log = Logger.getLogger(ShoppingCartSummaryPage.class);

    private By proceedToCheckout_btn = By.xpath("//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']");


    public CheckoutProcessAddressPage shoppingCartSummaryPage_clickProceedToCheckout() throws TestAutomationException {
        test_step_logger();
        findElement(proceedToCheckout_btn).click();
        log.info("[Step]: Click \"Procced to checkout\" button on SHOPPING-CART SUMMARY page");
        return new CheckoutProcessAddressPage();
    }

}
