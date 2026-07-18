package com.lakshitha.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {

    private WebDriver driver;

    // Locators
    private By finishButton = By.id("finish");
    private By completeHeader = By.className("complete-header");

    // Constructor
    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    // Click Finish
    public void clickFinish() {
        driver.findElement(finishButton).click();
    }

    // Get Success Message
    public String getSuccessMessage() {
        return driver.findElement(completeHeader).getText();
    }
}