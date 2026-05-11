# Test Automation Framework

### Java • Selenium WebDriver • TestNG • Page Object Model

End-to-end UI test automation framework built for the
[SauceDemo](https://www.saucedemo.com) e-commerce application.
Covers the full purchase flow from login through order confirmation,
structured using the Page Object Model design pattern.

---

## Project Structure

```
test-automation-framework/
├── src/test/java/
│   ├── base/
│   │   └── BaseTest.java         # WebDriver setup and teardown
│   ├── pages/
│   │   ├── LoginPage.java        # Login page locators and actions
│   │   ├── InventoryPage.java    # Product listing locators and actions
│   │   ├── CartPage.java         # Cart page locators and actions
│   │   └── CheckoutPage.java     # Checkout page locators and actions
│   ├── tests/
│   │   ├── LoginTest.java        # Login test cases
│   │   └── PurchaseTest.java     # End-to-end purchase flow
│   └── utils/
│       └── TestData.java         # Centralized test data
├── src/test/resources/
│   └── testng.xml                # TestNG suite configuration
└── pom.xml
```

## Test Coverage

| Test | Scenario | Type |
|------|----------|------|
| testSuccessfulLogin | Valid credentials navigates to inventory | Positive |
| testLockedOutUser | Locked user sees error message | Negative |
| testPurchaseFlow | Full login → add to cart → checkout flow | E2E |

---

## Tech Stack

| Tool | Purpose |
|------|---------|
| **Selenium WebDriver 4** | Browser automation |
| **TestNG** | Test execution and assertions |
| **Java 19** | Primary language |
| **Page Object Model** | Separates locators and actions from test logic |
| **Maven** | Build and dependency management |
| **GitHub Actions** | CI pipeline — runs tests on every push |

---

## Design Decisions

**Page Object Model** — Every page has a dedicated class containing
locators and action methods. Tests contain only assertions and
flow logic, with zero duplicated selectors.

**Centralized test data** — All credentials and form data live
in `TestData.java`. No hardcoded values inside test classes.

**WebDriverWait** — Explicit waits used throughout instead of
`Thread.sleep()`, making the suite stable and fast.

**data-test attributes** — Where available, locators target
`data-test` attributes over CSS classes or XPath, making
selectors more resilient to UI changes.

---

## Running the Tests

### Prerequisites
- Java 19+
- Maven 3.8+
- Google Chrome

### Run all tests
```bash
mvn clean test
```

### Run a specific test class
```bash
mvn clean test -Dtest=LoginTest
mvn clean test -Dtest=PurchaseTest
```

---

## CI/CD

This project uses **GitHub Actions** to automatically run the
full test suite on every push and pull request to main.

---

## Author
**Iasia Cooper** — QA Engineer
[LinkedIn](https://linkedin.com/in/iasia-cooper-30b433225) •
[GitHub](https://github.com/IasiaCoop)


