package com.hellofresh.challenge.tests;

import com.hellofresh.base.BaseTest;
import com.hellofresh.challenge.pageobjects.GoogleSearch;
import com.hellofresh.exceptions.TestAutomationException;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    public void searchForSelenium() throws TestAutomationException {
        new GoogleSearch().entryQuery("Selenium").getSearchResults().verifyResults("Selenium - Web Browser Automation");
    }

    @Test
    public void searchForAppium() throws TestAutomationException {
        new GoogleSearch().entryQuery("Appium").getSearchResults();
//                .verifyResults("Selenium - Web Browser Automation");
    }

    @Test
    public void searchForRandomText() throws TestAutomationException {
        new GoogleSearch().enterRandomQuery().getSearchResults().verifyResults("SriLanka");
    }

//    @Test
    public void searchFromDataFile() throws TestAutomationException {
        new GoogleSearch().searchFromDataFile().getSearchResults();
    }
}
