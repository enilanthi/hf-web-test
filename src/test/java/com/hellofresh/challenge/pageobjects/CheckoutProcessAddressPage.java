package com.hellofresh.challenge.pageobjects;

import com.hellofresh.base.BasePage;
import com.hellofresh.exceptions.TestAutomationException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 * This refers to the page which has shipping and billing address details during the checkout process
 */
public class CheckoutProcessAddressPage extends BasePage {

    private static Logger log = Logger.getLogger(CheckoutProcessAddressPage.class);

    private By proceedToCheckout_btn = By.name("processAddress");


    public ShippingPage checkoutProcessAddressPage_clickProceedWithDefaultAddress() throws TestAutomationException {
        test_step_logger();
        findElement(proceedToCheckout_btn).click();
        log.info("[Step]: Click \"Procced to checkout\" button on Address details page, " +
                "while leaving the default address details");
        return new ShippingPage();
    }

}
