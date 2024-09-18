package Pages.Payments.PayAnyone;

import Locators.GlobalLocators;
import Pages.Config.ConfigReader;
import Utils.ScrollToUtils;
import Utils.WaitUtils;
import org.openqa.selenium.By;

import static Pages.Base.BasePage.driver;

public class DeleteIbanFromPayeeList {
    WaitUtils waitUtils = new WaitUtils(driver);  // Initialize WaitUtils with the driver
    //@Test
    public void deletepayeeAction() throws InterruptedException {
        ConfigReader configReader = new ConfigReader("src/main/resources/config.properties");
        By deleteBtn = new By.ByXPath("//XCUIElementTypeButton[@name=\"delete\"]");
        By deleteBtn2 = new By.ByXPath("//XCUIElementTypeStaticText[@name=\"Delete\"]");
        By completedsuccessfully = new By.ByXPath("//XCUIElementTypeStaticText[@name=\"Completed Successfully!\"]");
        By doneBtn = new By.ByXPath("//XCUIElementTypeStaticText[@name=\"Done\"]");
        By paymentsLocator = GlobalLocators.paymentsMenu();
        By payanyoneLocator = GlobalLocators.payanyoneMenu();


        waitUtils.waitForElementToBeClickable(paymentsLocator); //Click Payments Menu
        waitUtils.waitForElementToBeClickable(payanyoneLocator); // Click Payanyone Menu
        ScrollToUtils.scrollToText(driver, configReader.getIBAN()); // Scroll to IBAN
        //System.out.println("IBAN Found");
        driver.findElement(deleteBtn).click();
        driver.findElement(deleteBtn2).click();
        waitUtils.waitForElementToBeClickable(completedsuccessfully).isDisplayed();
        System.out.println("Payee Deleted Successfully");
        waitUtils.waitForElementToBeClickable(doneBtn);
        GlobalLocators.backBtn();
    }
}
