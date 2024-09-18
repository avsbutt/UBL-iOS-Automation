package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import static Pages.Base.BasePage.driver;

public class FeatureScreenHandleUtils {
    private static final By getStartedBtn = new By.ByXPath("//XCUIElementTypeStaticText[@name=\"Get Started\"]"); //Use this Locator in the Feature Screen Handle Function
    //public static By getstartedBtnvisible() { return By.xpath("//XCUIElementTypeStaticText[@name=\"Get Started\"]"); }

    public static boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true; // Element found
        } catch (NoSuchElementException e) {
            return false; // Element not found
        }
    }

    public static void ClickGetStartedIfFeatureScreenAppear() throws InterruptedException {
        Thread.sleep(2000);
        if (isElementPresent(getStartedBtn)) {
            driver.findElement(getStartedBtn).click();
            System.out.println("Banner Appear and Get Started clicked successfully");
        } else {
            System.out.println("Banner is not Appeared");
        }
    }
}