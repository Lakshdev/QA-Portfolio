package com.lakshitha.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    private WebDriver driver;

    // Locators
    private By pageTitle = By.className("title");
    private By addBackpackButton = By.id("add-to-cart-sauce-labs-backpack");
    private By cartBadge = By.className("shopping_cart_badge");
    private By cartIcon = By.className("shopping_cart_link");

    // Constructor
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // Verify page title
    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    // Add backpack to cart
    public void addBackpackToCart() {
        driver.findElement(addBackpackButton).click();
    }

    // Cart badge count
    public String getCartBadgeCount() {
        return driver.findElement(cartBadge).getText();
    }

    // Open cart
    public void openCart() {
        driver.findElement(cartIcon).click();
    }
}