package com.lakshitha.qa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.lakshitha.qa.pages.LoginPage;
import com.lakshitha.qa.pages.ProductPage;

public class ProductPageTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductPage productPage;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);

        productPage = new ProductPage(driver);

        loginPage.login("standard_user", "secret_sauce");

    }

    @Test
    public void verifyProductPage() {

        Assert.assertEquals(
                productPage.getPageTitle(),
                "Products"
        );

        productPage.addBackpackToCart();

        Assert.assertEquals(
                productPage.getCartBadgeCount(),
                "1"
        );

    }

    @AfterMethod
    public void tearDown() {

        driver.quit();

    }

}