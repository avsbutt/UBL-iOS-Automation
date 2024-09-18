package Pages.Payments.PayAnyone;

import Locators.GlobalLocators;
import Pages.Config.ConfigReader;
import Utils.ScrollToUtils;
import Utils.WaitUtils;
import org.openqa.selenium.By;
import static Pages.Base.BasePage.driver;

public class AddIbanToFavourite {
    static ConfigReader configReader = new ConfigReader("src/main/resources/config.properties");
    static WaitUtils waitUtils = new WaitUtils(driver);  // Initialize WaitUtils with the driver
    public static void favouritepayeeAction(){
        By paymentsLocator = GlobalLocators.paymentsMenu();
        By payanyoneLocator = GlobalLocators.payanyoneMenu();
        By addFavouriteBtn = new By.ByXPath("");

        waitUtils.waitForElementToBeClickable(paymentsLocator); //Click Payments Menu
        waitUtils.waitForElementToBeClickable(payanyoneLocator); // Click Payanyone Menu
        driver.findElement(addFavouriteBtn).click();

        ScrollToUtils.scrollToText(driver, configReader.getIBAN()); // Scroll to IBAN
        //Assert.assertTrue(configReader.getIBAN());
    }
}
