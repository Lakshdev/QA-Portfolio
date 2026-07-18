package com.lakshitha.qa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lakshitha.qa.pages.LoginPage;

public class LoginPageTest {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
    }

    @Test
    public void verifyValidLogin() {
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory"),
                "Login failed: Products page was not opened."
        );
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}