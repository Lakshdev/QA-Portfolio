package com.lakshitha.qa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.lakshitha.qa.pages.CartPage;
import com.lakshitha.qa.pages.CheckoutPage;
import com.lakshitha.qa.pages.LoginPage;
import com.lakshitha.qa.pages.ProductPage;

public class CheckoutPageTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);

        loginPage.login("standard_user", "secret_sauce");

    }

    @Test
    public void verifyCheckoutInformation() {

        productPage.addBackpackToCart();

        productPage.openCart();

        cartPage.clickCheckout();

        checkoutPage.checkoutInformation(
                "Lakshitha",
                "Sandaruwan",
                "91500"
        );

        Assert.assertEquals(
                checkoutPage.getOverviewTitle(),
                "Checkout: Overview"
        );

    }

    @AfterMethod
    public void tearDown() {

        if(driver!=null)
            driver.quit();

    }

}