package Pages.Payments.PayAnyone;

import Utils.AlertsHandleUtils;
import Utils.FeatureScreenHandleUtils;
import Utils.WaitUtils;
import Locators.GlobalLocators;
import Pages.Config.ConfigReader;
import org.openqa.selenium.By;
import static Pages.Base.BasePage.driver;

public class AddIbanToPayee {
    WaitUtils waitUtils = new WaitUtils(driver);  // Initialize WaitUtils with the driver
    AlertsHandleUtils alertsHandleUtils = new AlertsHandleUtils();
   private final By IBANBtn = new By.ByXPath("//XCUIElementTypeStaticText[@name=\"\u200EIBAN\"]");
    private final By yesBtn = new By.ByXPath("//XCUIElementTypeStaticText[@name=\"Yes\"]");
    private final By futureTxt = new By.ByXPath("//XCUIElementTypeStaticText[@name=\"Do you want this payee for future payments?\"]");
    private final By alreadyRegisteredTxt = new By.ByXPath("//XCUIElementTypeStaticText[@name=\"Account is already registered as payee account\"]");
    private final By completedTxt = new By.ByXPath("//XCUIElementTypeStaticText[@name=\"Completed Successfully!\"]");
    private final By newBtn = new By.ByXPath("//XCUIElementTypeStaticText[@name=\"New\"]");

    public void addNewIbanInPayee() throws InterruptedException {
        ConfigReader configReader = new ConfigReader("src/main/resources/config.properties");
        By paymentsLocator = GlobalLocators.paymentsMenu();
        By payanyoneLocator = GlobalLocators.payanyoneMenu();
        By textFieldLocator = GlobalLocators.textField();
        By continueLocator = GlobalLocators.continueBtn();
        By backLocator = GlobalLocators.backBtn();
        By alertCheck = GlobalLocators.alert();

        waitUtils.waitForElementToBeClickable(paymentsLocator).click(); // Click Payments Menu
        driver.findElement(payanyoneLocator).click(); // Click Payanyone Menu
        FeatureScreenHandleUtils.ClickGetStartedIfFeatureScreenAppear();  // Handle Feature Screen if appear

        waitUtils.waitForElementToBeClickable(newBtn).click(); //Click new Button
        driver.findElement(IBANBtn).click(); // Click IBAN
        waitUtils.waitForElementToBeClickable(textFieldLocator).sendKeys(configReader.getIBAN());
        waitUtils.waitForElementToBeClickable(yesBtn).click();
        waitUtils.waitForElementToBeClickable(futureTxt).click();
        waitUtils.waitForElementToBeClickable(continueLocator).click();
        AlertsHandleUtils.alerthandle(alertCheck);  // Check whether IBAN is incorrect or not
        waitUtils.waitForElementToBeClickable(continueLocator).click();
        System.out.println("IBAN is correct");

    // Now handle the "Already Registered" and "Completed" cases
    try {
        // Check if the IBAN is already registered
        if (FeatureScreenHandleUtils.isElementPresent(alreadyRegisteredTxt)) {
            if (waitUtils.waitForElementToBeClickable(alreadyRegisteredTxt).isDisplayed()) {
                System.out.println("Account is Already registered as Payee Account");
                driver.findElement(GlobalLocators.closeBtn()).click(); // Close the pop-up
                return;  // Exit the method after handling the already registered case
            }
        }
    } catch (Exception e) {
        System.out.println("Error while checking if IBAN is already registered: " + e.getMessage());
    }
    // If not already registered, check if the process completed successfully
    try {
        waitUtils.waitForElementToBeClickable(completedTxt); // Wait for the "Completed Successfully!" message
        System.out.println("Account Added with IBAN " + configReader.getIBAN());
        driver.findElement(GlobalLocators.closeBtn()).click(); // Close the success message
        waitUtils.waitForElementToBeClickable(backLocator).click();
    } catch (Exception e) {
        System.out.println("Error during account addition process: " + e.getMessage());
        throw e;  // Re-throw the exception if there's an issue with completion
    }
    }
  }
