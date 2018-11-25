package com.hellofresh.challenge.pageobjects;

import com.hellofresh.base.BasePage;
import com.hellofresh.exceptions.TestAutomationException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 * This refers to the page which allow you to choose payment options and confirm your order
 */
public class PaymentPage extends BasePage {

    private static Logger log = Logger.getLogger(PaymentPage.class);

    private By bankWire_div = By.className("bankwire");
    private By confirmOrder_btn = By.xpath("//*[@id='cart_navigation']/button");


    public PaymentPage paymentPage_clickPayByBankWire() throws TestAutomationException {
        test_step_logger();
        findElement(bankWire_div).click();
        log.info("[Step]: Click \"Pay by Bank wire\" option on Payment page");
        return this;
    }

    public OrderConfirmationPage paymentPage_clickConfirmOrderButton() throws TestAutomationException {
        test_step_logger();
        findElement(confirmOrder_btn).click();
        log.info("[Step]: Click \"I confirm my order\" option on Payment page");
        return new OrderConfirmationPage();
    }

}
