package com.lakshitha.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    // Locators
    private By productName = By.className("inventory_item_name");
    private By checkoutButton = By.id("checkout");

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Get product name
    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    // Click Checkout
    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }
}