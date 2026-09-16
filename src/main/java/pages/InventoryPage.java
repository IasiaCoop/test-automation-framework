package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    //Locators
    private final By backpackAddButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartBadge = By.className("shopping_cart_badge");
    private final By cartLink = By.className("shopping_cart_link");
    private final By productsTitle = By.cssSelector("[data-test='title']");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void addBackpackToCart() {

        WebElement button = wait.until(
                ExpectedConditions.elementToBeClickable(backpackAddButton)
        );

        button.click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(cartBadge)
        );
    }


    public String getCartCount() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(cartBadge)
        ).getText();
    }


    public void goToCart() {
        driver.get("https://www.saucedemo.com/cart.html");
        wait.until(
                ExpectedConditions.urlContains("cart.html")
        );
        System.out.println("Cart page loaded: " + driver.getCurrentUrl());






    }


    public boolean isPageLoaded() {

        WebElement title = wait.until(
                ExpectedConditions.visibilityOfElementLocated(productsTitle)
        );

        System.out.println("Page title found: " + title.getText());

        return title.getText().equals("Products");
    }
}

