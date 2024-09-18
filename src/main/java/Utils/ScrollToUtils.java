package Utils;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;

import java.util.HashMap;

public class ScrollToUtils {
    public static void scrollToText(IOSDriver driver, String text) {
        By elementLocator = By.xpath("//*[contains(@name, '" + text + "')]");
        scrollToElement(driver, elementLocator);
        //driver.findElement(elementLocator).click();
    }


    private static void scrollToElement(IOSDriver driver, By locator) {
        HashMap<String, String> scrollObject = new HashMap<>();   // Scroll to the element until it becomes visible
        scrollObject.put("direction", "down");
        scrollObject.put("toVisible", locator.toString());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            // Scroll to the element until it becomes visible
            js.executeScript("mobile:scroll", scrollObject);
            // If the element is found after scrolling, click on it
            driver.findElement(locator).click();
            System.out.println("Element found and clicked");
        } catch (NoSuchElementException e) {
            // If the element is not found after scrolling, print a message
            System.out.println("Element not found");
        }
    }
}
