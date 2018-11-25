package com.hellofresh.challenge.pageobjects;

import com.hellofresh.base.BasePage;
import com.hellofresh.exceptions.TestAutomationException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 * This refers to the Order Confirmation page
 */
public class OrderConfirmationPage extends BasePage {

    private static Logger log = Logger.getLogger(OrderConfirmationPage.class);

    private By header_panel = By.cssSelector("h1");
    private By shipping_tab = By.xpath("//li[@class='step_done step_done_last four']");
    private By payment_tab = By.xpath("//li[@id='step_end' and @class='step_current last']");
    private By completionMsg_lbl = By.xpath("//*[@class='cheque-indent']/strong");

    public OrderConfirmationPage orderConfirmPage_verifyHeading(String heading) throws TestAutomationException {
        test_step_logger();
        verifyEquals(heading, findElement(header_panel).getText());
        log.info("[Step]: Verify the heading on ORDER CONFIRMATION page");
        return this;
    }

    public OrderConfirmationPage orderConfirmPage_verifyShippingAndPaymentBreadcrumbs() throws TestAutomationException {
        test_step_logger();
        verifyTrue(findElement(shipping_tab).isDisplayed());
        verifyTrue(findElement(payment_tab).isDisplayed());
        log.info("[Step]: Verify if the breadcrumb for Shipping and Payment are displayed on ORDER CONFIRMATION page");
        return this;
    }

    public OrderConfirmationPage orderConfirmPage_verifyOrderCompletionMessage() throws TestAutomationException {
        test_step_logger();
        verifyTrue(findElement(completionMsg_lbl).getText().contains("Your order on My Store is complete."));
        log.info("[Step]: Verify if order completion message is displayed on ORDER CONFIRMATION page");
        return this;
    }

    public OrderConfirmationPage orderConfirmPage_verifySubStringInURL(String stringToBeLookedFor) {
        test_step_logger();
        verifyTrue(getDriver().getCurrentUrl().contains(stringToBeLookedFor));
        log.info("[Step]: Verify if the current url includes: " + stringToBeLookedFor);
        return this;
    }


}
