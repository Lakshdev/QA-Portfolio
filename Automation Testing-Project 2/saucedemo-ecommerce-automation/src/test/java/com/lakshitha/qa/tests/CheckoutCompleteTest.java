package com.lakshitha.qa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.lakshitha.qa.pages.*;

public class CheckoutCompleteTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private CheckoutCompletePage completePage;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        completePage = new CheckoutCompletePage(driver);

        loginPage.login("standard_user", "secret_sauce");
    }

    @Test
    public void verifyCompleteOrder() {

        productPage.addBackpackToCart();

        productPage.openCart();

        cartPage.clickCheckout();

        checkoutPage.checkoutInformation(
                "Lakshitha",
                "Sandaruwan",
                "91500"
        );

        completePage.clickFinish();

        Assert.assertEquals(
                completePage.getSuccessMessage(),
                "Thank you for your order!"
        );
    }

    @AfterMethod
    public void tearDown() {

        if(driver != null)
            driver.quit();
    }
}