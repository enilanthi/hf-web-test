package com.hellofresh.challenge.pageobjects;

import com.hellofresh.base.BasePage;
import com.hellofresh.exceptions.TestAutomationException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 * This refers to the page which allow you to choose shipping options
 */
public class ShippingPage extends BasePage {

    private static Logger log = Logger.getLogger(ShippingPage.class);

    private By termsAgreement_checkBox = By.id("uniform-cgv");
    private By proceedToCheckout_btn = By.name("processCarrier");


    public ShippingPage shippingPage_tickAgreeToTermsOfService() throws TestAutomationException {
        test_step_logger();
        findElement(termsAgreement_checkBox).click();
        log.info("[Step]: Tick agree to \"Terms of service\" on SHIPPING page");
        return this;
    }

    public PaymentPage shippingPage_clickProceedToCheckout() throws TestAutomationException {
        test_step_logger();
        findElement(proceedToCheckout_btn).click();
        log.info("[Step]: Click \"Procced to checkout\" button on SHIPPING page");
        return new PaymentPage();
    }

}
