package com.lakshitha.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver driver;

    // Locators
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By overviewTitle = By.className("title");

    // Constructor
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstName(String fname) {
        driver.findElement(firstName).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        driver.findElement(lastName).sendKeys(lname);
    }

    public void enterPostalCode(String code) {
        driver.findElement(postalCode).sendKeys(code);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public void checkoutInformation(String fname, String lname, String code) {
        enterFirstName(fname);
        enterLastName(lname);
        enterPostalCode(code);
        clickContinue();
    }

    public String getOverviewTitle() {
        return driver.findElement(overviewTitle).getText();
    }
}