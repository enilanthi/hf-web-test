package com.hellofresh.challenge.pageobjects;

import com.hellofresh.base.BasePage;
import com.hellofresh.exceptions.TestAutomationException;
import com.hellofresh.util.TestDataReader;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

/**
 * This refers to the page that displays all details about a selected item
 */
public class ItemDetailsPage extends BasePage {

    private static Logger log = Logger.getLogger(ItemDetailsPage.class);

    private By quantity_inputFld = By.id("quantity_wanted");
    private By size_dropDown = By.id("group_1");
    private By addToCart_Btn = By.name("Submit");
    private By proceedToCheckout_btn = By.xpath("//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']");

    public ItemDetailsPage itemDetailsPage_selectQuantity() throws TestAutomationException {
        test_step_logger();

        JSONObject object = TestDataReader.readTestData("OrderDetails.json");
        String quantity = object.get("quantity").toString();

        findElement(quantity_inputFld).clear();
        findElement(quantity_inputFld).sendKeys(quantity);
        log.info("[Step]: Select quantity as: \""+quantity+"\", in item details page");
        return this;
    }

    public ItemDetailsPage itemDetailsPage_selectSize() throws TestAutomationException {
        test_step_logger();

        JSONObject object = TestDataReader.readTestData("OrderDetails.json");
        String size = object.get("size").toString();
        Select select = new Select(findElement(size_dropDown));
        select.selectByVisibleText(size);
        log.info("[Step]: Select size as: \""+size+"\", in item details page");
        return this;
    }

    public ItemDetailsPage itemDetailsPage_clickAddToCartButton() throws TestAutomationException {
        test_step_logger();
        findElement(addToCart_Btn).click();
        log.info("[Step]: Click \"Add to cart\" button on item details page");
        return this;
    }

    public ShoppingCartSummaryPage itemDetailsPage_clickProceedToCheckoutButton() throws TestAutomationException {
        test_step_logger();
        waitUntilElementVisibleAndFind(proceedToCheckout_btn).click();
        log.info("[Step]: Click \"Procced to checkout\" button on item details page");
        return new ShoppingCartSummaryPage();
    }
}
