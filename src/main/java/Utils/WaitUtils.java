package Utils;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitUtils {
    private final IOSDriver driver;

    // Constructor to initialize driver
    public WaitUtils(IOSDriver driver) {
        this.driver = driver;
    }

    // Method to wait for an element to be clickable
    public WebElement waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(80));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return element;
    }
}
