package com.hellofresh.challenge.pageobjects;

import com.hellofresh.base.BasePage;
import com.hellofresh.exceptions.TestAutomationException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

/**
 * This page refers to the Register new user page. That is creating a new user account
 */
public class AccountCreationPage extends BasePage {

    private static Logger log = Logger.getLogger(AccountCreationPage.class);

    private By firstname_inputFld = By.id("customer_firstname");
    private By lastname_inputFld = By.id("customer_lastname");
    private By passwd_inputFld = By.id("passwd");
    private By date_DOB_dropDown = By.id("days");
    private By month_DOB_dropDown = By.id("months");
    private By year_DOB_dropDown = By.id("years");

    //    Address details
    private By company_inputFld = By.id("company");
    private By address1_inputFld = By.id("address1");
    private By address2_inputFld = By.id("address2");
    private By city_inputFld = By.id("city");
    private By state_dropDown = By.id("id_state");
    private By postcode_inputFld = By.id("postcode");
    private By info_inputFld = By.id("other");
    private By homePhone_inputFld = By.id("phone");
    private By mobilePhone_inputFld = By.id("phone_mobile");
    private By alias_inputFld = By.id("alias");

    //    Registeter button
    private By register_btn = By.id("submitAccount");

    public AccountCreationPage accountCreationPage_EnterPersonalInfo() throws TestAutomationException {
        test_step_logger();
        findElement(firstname_inputFld).sendKeys(faker.name().firstName());
        findElement(lastname_inputFld).sendKeys(faker.name().lastName());
        findElement(passwd_inputFld).sendKeys("Qwerty");
        Select select = new Select(findElement(date_DOB_dropDown));
        select.selectByValue(String.valueOf(faker.number().numberBetween(1, 30)));
        select = new Select(findElement(month_DOB_dropDown));
        select.selectByValue(String.valueOf(faker.number().numberBetween(1, 12)));
        select = new Select(findElement(year_DOB_dropDown));
        select.selectByValue(String.valueOf(faker.number().numberBetween(1950, 2000)));
        log.info("[Step]: Enter personal details on registration page");
        return this;
    }

    public AccountCreationPage accountCreationPage_EnterAddressInfo() throws TestAutomationException {
        test_step_logger();
        String companyName = faker.company().name();
        findElement(company_inputFld).sendKeys(companyName);
        findElement(address1_inputFld).sendKeys(companyName);
        findElement(address2_inputFld).sendKeys(faker.address().buildingNumber() + ", " +
                faker.address().streetAddress());
        findElement(city_inputFld).sendKeys(faker.address().cityName());

        Select select = new Select(findElement(state_dropDown));
        select.selectByVisibleText("Colorado");

        findElement(postcode_inputFld).sendKeys(faker.number().digits(5));
        findElement(info_inputFld).sendKeys("N/A");
        findElement(homePhone_inputFld).sendKeys(faker.phoneNumber().cellPhone());
        findElement(mobilePhone_inputFld).sendKeys(faker.phoneNumber().cellPhone());
        findElement(alias_inputFld).sendKeys(faker.lordOfTheRings().character());
        log.info("[Step]: Enter address details on registration page");
        return this;
    }

    public MyAccountPage accountCreationPage_clickRegistrationButton() throws TestAutomationException {
        test_step_logger();
        findElement(register_btn).click();
        log.info("[Step]: Click \"Register\" button on registration page");
        return new MyAccountPage();
    }
}
