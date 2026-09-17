package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");
    private final By continueButton = By.id("continue");
    private final By cancelButton = By.id("cancel");
    private final By finishButton = By.id("finish");
    private final By confirmationMessage = By.cssSelector("[data-test='complete-header']");
    private final By summaryInfo = By.className("summary_info");
    private final By errorMessage = By.cssSelector("[data-test='error']");


    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }


    public void fillOutInformation(String firstName, String lastName, String postalCode) {
        WebElement first = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        first.click();
        first.clear();
        first.sendKeys(firstName);

        WebElement last = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
        last.click();
        last.clear();
        last.sendKeys(lastName);

        WebElement postal = wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeField));
        postal.click();
        postal.clear();
        postal.sendKeys(postalCode);
    }

        public void clickCancelButton() {
            wait.until(ExpectedConditions.elementToBeClickable(cancelButton)).click();
        }


        public void clickContinueButton() {

            WebElement button = wait.until(
                    ExpectedConditions.elementToBeClickable(continueButton)
            );

            System.out.println("Continue button found.");
            System.out.println("Continue displayed: " + button.isDisplayed());
            System.out.println("Continue enabled: " + button.isEnabled());

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block: 'center'});",
                    button
            );

            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].click();",
                    button
            );

            System.out.println("After Continue URL: " + driver.getCurrentUrl());

            wait.until(
                    ExpectedConditions.urlContains("checkout-step-two.html")
            );

            System.out.println("Checkout Step 2 loaded.");;
    }

        public void clickFinishButton() {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(finishButton));
            button.click();
        }


    public String getConfirmationMessage() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(confirmationMessage)
        ).getText();

    }
    public String getErrorMessage() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(errorMessage)
        ).getText();
    }



}
