package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CartPage {

    private final WebDriver driver;
    WebDriverWait wait;


    //Locators
    private final By checkoutButton = By.id("checkout");


    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait =  new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    public void clickOnCheckoutButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }
}
