package com.hellofresh.challenge.pageobjects;

import com.hellofresh.base.BasePage;
import com.hellofresh.exceptions.TestAutomationException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

/**
 * Sign In page - which allows you to create an account for new users or provide sign in option for existing users
 */
public class SignInPage extends BasePage {

    private static Logger log = Logger.getLogger(SignInPage.class);

//    Create account
    private By email_inputField = By.id("email_create");
    private By createAccount_btn = By.id("SubmitCreate");

//    Sign In
    private By userName_inputField = By.id("email");
    private By password_inputField = By.id("passwd");
    private By signIn_btn = By.id("SubmitLogin");

    public AccountCreationPage signInPage_createAnAccount() throws TestAutomationException {
        test_step_logger();
        String email = faker.name().firstName()+"_"+faker.number().digits(4)+"@autopractice123456.com";
        findElement(email_inputField).sendKeys(email);
        findElement(createAccount_btn).click();
        log.info("[Step]: Enter email address: "+email+" and click \"Create an Account\" button");
        return new AccountCreationPage();
    }

    public MyAccountPage signInPage_signInToAccount(String existingUserEmail, String existingUserPassword) throws TestAutomationException {
        test_step_logger();
        findElement(userName_inputField).sendKeys(existingUserEmail);
        findElement(password_inputField).sendKeys(existingUserPassword);
        findElement(signIn_btn).click();
        log.info("[Step]: Enter email: "+existingUserEmail+", password: "+existingUserPassword+" and click sign in");
        return new MyAccountPage();
    }

}
