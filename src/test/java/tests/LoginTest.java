package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.TestData;

public class LoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin()  {
        LoginPage login = new LoginPage(driver);
        login.login(TestData.USERNAME, TestData.PASSWORD);
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));

    }

    @Test
    public void testLockedOutUser() {
        LoginPage login = new LoginPage(driver);
        login.login(TestData.LOCKED_USER, TestData.PASSWORD);
       Assert.assertTrue(login.isErrorMessageDisplayed());
    }
}
