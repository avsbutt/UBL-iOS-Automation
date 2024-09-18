package Pages.Login;

import Pages.Config.ConfigReader;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pages.Base.BasePage;
import java.time.Duration;
import java.util.HashMap;

public class LoginPage {

    IOSDriver driver;
    private static ConfigReader configReader;
    // Constructor to fetch the driver from BasePage
    public LoginPage() {
        this.driver = BasePage.getDriver();
        configReader = new ConfigReader("src/main/resources/config.properties");
    }
    // Login Page Locators
    private final By usernameInput = new By.ByXPath("//XCUIElementTypeTextField");
    private final By passwordInput = new By.ByXPath("//XCUIElementTypeSecureTextField");
    private final By signinBtn = new By.ByXPath("//XCUIElementTypeButton[@name=\"Sign in\"]");
    private final By touchidLocator = new By.ByXPath("//XCUIElementTypeStaticText[@name='Would you like to enable Touch ID?']");
    private final By closeBtn = new By.ByXPath("//XCUIElementTypeButton[@name=\"close\"]");
    private final By showBalance = new By.ByXPath("//XCUIElementTypeApplication[@name=\"UBLDigital\"]");

    // Swipe method using JavascriptExecutor
    public void swipeUpFromMiddle() {
        HashMap<String, String> scrollObject = new HashMap<>();
        JavascriptExecutor js = driver;
        scrollObject.put("direction", "down");
        js.executeScript("mobile: scroll", scrollObject); //or "mobile: swipe"
    }

    // Login method
    public void typeLoginCredential() {

        //Initialize Variable to Get the data from the config reader file
        String username = configReader.getUsername();
        String password = configReader.getPassword();

        // Enter username and password
        driver.findElement(usernameInput).clear();
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(signinBtn).click();
    }
    public void verifyLoginIsSuccess() {

        // Wait for the Touch ID popup to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement touchid = wait.until(ExpectedConditions.presenceOfElementLocated(touchidLocator));

        // Handle the Touch ID popup if displayed after Login
        if (touchid.isDisplayed()) {
            driver.findElement(closeBtn).click();
            System.out.println("Touch ID Alert Appeared and closed without Enabling.");
        } else {
            System.out.println("Touch ID Popup did not appear.");
        }
        driver.findElement(showBalance).isDisplayed();
        System.out.println("Login Success");
    }
}