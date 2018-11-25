package com.hellofresh.challenge.pageobjects;

import com.hellofresh.base.BasePage;
import com.hellofresh.exceptions.TestAutomationException;
import com.hellofresh.util.TestDataReader;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class GoogleSearch extends BasePage {

    Logger log = Logger.getLogger(GoogleSearch.class);

    public GoogleSearch entryQuery(String search) throws TestAutomationException {
        test_step_logger();
        findElement(By.xpath("//input[@class=\"gLFyf gsfi\"]")).sendKeys(search);
        log.info("[Step]: Enter query: "+search+" in search field");
        return this;
    }

    public GoogleSearchResults getSearchResults() throws TestAutomationException {
        test_step_logger();
        findElement(By.xpath("//input[@class=\"gLFyf gsfi\"]")).sendKeys(Keys.RETURN);
        log.info("[Step]: Click Search");
        return new GoogleSearchResults();
    }

    public GoogleSearch enterRandomQuery() throws TestAutomationException {
        test_step_logger();
        String query = faker.address().country();
        findElement(By.xpath("//input[@class=\"gLFyf gsfi\"]")).sendKeys(query);
        log.info("[Step]: Enter query: "+query+" in search field");
        return this;
    }

    public GoogleSearch searchFromDataFile() throws TestAutomationException {
        test_step_logger();
        JSONObject query = TestDataReader.readTestData("OrderDetails.json");
        findElement(By.xpath("//input[@class=\"gLFyf gsfi\"]")).sendKeys(query.get("dress").toString());
        log.info("[Step]: Enter query: "+query+" in search field");
        return this;
    }
}
