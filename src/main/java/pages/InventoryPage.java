package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private final  WebDriver driver;


    //Locator
    private final By backpackAddButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartBadge = By.className("shopping_cart_badge");
    private final By cartLink = By.className("shopping_cart_link");
    private final By productsTitle = By.cssSelector("[data-test='title']");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addBackpackToCart() {
        driver.findElement(backpackAddButton).click();
    }

    public String getCartCount(){
        return driver.findElement(cartBadge).getText();
    }

    public void goToCart() {
        driver.findElement(cartLink).click();
    }
    public boolean isPageLoaded() {
        return driver.findElement(productsTitle).getText().equals("Products");
    }



}
