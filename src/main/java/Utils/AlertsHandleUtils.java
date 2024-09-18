package Utils;

import Locators.GlobalLocators;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import static Pages.Base.BasePage.driver;
import static Utils.FeatureScreenHandleUtils.isElementPresent;

public class AlertsHandleUtils {

    public static void alerthandle(By locator) throws InterruptedException {
        Thread.sleep(2000);
        if (isElementPresent(locator)) {
            driver.findElement(locator).isDisplayed();
            GlobalLocators.closeBtn();
            System.out.println("Alert is Appear due to Error");
        } else {
            System.out.println("No Alert Appeared");
        }
    }
    public static void nointernetAlertHandle() {
        By alertLocator = new By.ByXPath("//XCUIElementTypeStaticText[@name=\"Our service seems to be inaccessible. Please check your internet connection and try again. We apologize for the inconvenience.\"]");

        if (driver.findElement(alertLocator).isDisplayed()) {
            System.out.println("No Internet Alert Appeared");
            GlobalLocators.closeBtn();
        } else {
            System.out.println("No internet Alert, Internet is working");
        }
    }
    public static void getalerttext() {
        try {
            // Wait for the alert to appear and switch to it
            Alert alert = driver.switchTo().alert();
            // Get the text from the alert
            String alertText = alert.getText();
            System.out.println("Text from alert: " + alertText);
        } catch (Exception e) {
            System.out.println("No alert is present");
        }
    }
}

