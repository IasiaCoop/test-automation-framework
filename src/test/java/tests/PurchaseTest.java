package tests;

import base.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.TestData;

import java.time.Duration;

public class PurchaseTest extends BaseTest {

    @Test
    public void testPurchaseFlow() {
        //Login
        LoginPage login = new LoginPage(driver);
        login.login(TestData.USERNAME, TestData.PASSWORD);
        //Add to Cart
        InventoryPage inventory = new InventoryPage(driver);
        Assert.assertTrue(inventory.isPageLoaded(), "Inventory page should be loaded.");
        inventory.addBackpackToCart();
        Assert.assertEquals(inventory.getCartCount(), "1", "Cart count should be 1!");
        inventory.goToCart();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("cart.html"));
        CartPage cart = new CartPage(driver);
        cart.clickOnCheckoutButton();
        //Checkout
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.fillOutInformation(TestData.FIRST_NAME, TestData.LAST_NAME, TestData.POSTAL_CODE);
        checkout.clickContinueButton();
        checkout.clickFinishButton();
        Assert.assertEquals(checkout.getConfirmationMessage(), "Thank you for your order!");

    }
}
