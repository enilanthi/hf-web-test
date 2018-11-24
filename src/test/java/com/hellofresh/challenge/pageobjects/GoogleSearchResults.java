package com.hellofresh.challenge.pageobjects;

import com.hellofresh.base.BasePage;
import com.hellofresh.exceptions.TestAutomationException;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class GoogleSearchResults extends BasePage {

    Logger log = Logger.getLogger(GoogleSearchResults.class);

    public GoogleSearchResults verifyResults(String result) throws TestAutomationException {
        test_step_logger();
        verifyTrue(findElement(By.xpath("//h3[text()=\""+result+"\"]")).isDisplayed(), "Expected results not found");
        log.info("[Step]: Verify search results: "+result);
        return this;
    }
}
