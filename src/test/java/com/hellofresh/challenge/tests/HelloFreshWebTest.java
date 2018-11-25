package com.hellofresh.challenge.tests;

import com.hellofresh.base.BaseTest;
import com.hellofresh.challenge.pageobjects.HomePage;
import com.hellofresh.exceptions.TestAutomationException;
import org.testng.annotations.Test;

public class HelloFreshWebTest extends BaseTest {

    @Test
    public void newUserRegistrationTest() throws TestAutomationException {
        new HomePage().homePage_clickSignIn()
                .signInPage_createAnAccount()
                .accountCreationPage_EnterPersonalInfo()
                .accountCreationPage_EnterAddressInfo()
                .accountCreationPage_clickRegistrationButton()
                .verifyHeading("MY ACCOUNT")
                .verifyCustomerName()
                .verifyWelcomeMessage()
                .verifySignOutLinkDisplayed()
                .verifySubStringInCurrentURL("controller=my-account");
    }

    @Test
    public void existingUserSignInTest() throws TestAutomationException {
        new HomePage().homePage_clickSignIn()
                .signInPage_signInToAccount("autouser24112018@autoprac12345.com",
                        "12345678")
                .verifyHeading("MY ACCOUNT")
                .verifyCustomerName("Joe Black")
                .verifyWelcomeMessage()
                .verifySignOutLinkDisplayed()
                .verifySubStringInCurrentURL("controller=my-account");
    }

    @Test
    public void itemCheckoutTest() throws TestAutomationException {
        new HomePage().homePage_clickSignIn()
                .signInPage_signInToAccount("autouser24112018@autoprac12345.com",
                        "12345678")
                .clickCatoryAsWomen()
                .clickShortSleeveTshirt()
                // NOTE: quantity and size are read from external file
                .itemDetailsPage_selectQuantity()
                .itemDetailsPage_selectSize()
                .itemDetailsPage_clickAddToCartButton()
                .itemDetailsPage_clickProceedToCheckoutButton()
                .shoppingCartSummaryPage_clickProceedToCheckout()
                .checkoutProcessAddressPage_clickProceedWithDefaultAddress()
                .shippingPage_tickAgreeToTermsOfService()
                .shippingPage_clickProceedToCheckout()
                .paymentPage_clickPayByBankWire()
                .paymentPage_clickConfirmOrderButton()
                .orderConfirmPage_verifyHeading("ORDER CONFIRMATION")
                .orderConfirmPage_verifyShippingAndPaymentBreadcrumbs()
                .orderConfirmPage_verifyOrderCompletionMessage()
                .orderConfirmPage_verifySubStringInURL("controller=order-confirmation");
    }

    @Test
    public void existingUserSignIn_FailingTest() throws TestAutomationException {
        new HomePage().homePage_clickSignIn()
                .signInPage_signInToAccount("autouser24112018@autoprac12345.com",
                        "12345678")
                .verifyHeading("MY ACCOUNT XX")
                .verifyCustomerName("Joe Black")
                .verifyWelcomeMessage()
                .verifySignOutLinkDisplayed()
                .verifySubStringInCurrentURL("controller=my-account");
    }
}
