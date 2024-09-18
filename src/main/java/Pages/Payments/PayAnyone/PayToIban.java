package Pages.Payments.PayAnyone;

import Locators.GlobalLocators;
import Pages.Config.ConfigReader;
import Utils.FeatureScreenHandleUtils;
import Utils.ScrollToUtils;
import Utils.WaitUtils;
import org.openqa.selenium.By;
import static Pages.Base.BasePage.driver;

public class PayToIban {
    ConfigReader configReader = new ConfigReader("src/main/resources/config.properties");
    WaitUtils waitUtils = new WaitUtils(driver);
    public void PayanyoneAction() throws InterruptedException {

        By paynowLocator = GlobalLocators.paynowBtn();
        By paymentsLocator = GlobalLocators.paymentsMenu();
        By payanyoneLocator = GlobalLocators.payanyoneMenu();
        By continueLocator = GlobalLocators.continueBtn();


        waitUtils.waitForElementToBeClickable(paymentsLocator); //Click Payments Menu
        waitUtils.waitForElementToBeClickable(payanyoneLocator); // Click Payanyone Menu
        FeatureScreenHandleUtils.ClickGetStartedIfFeatureScreenAppear(); // Wait for the banner to appear ()
        ScrollToUtils.scrollToText(driver, configReader.getIBAN()); // Scroll to IBAN
        System.out.println("IBAN Found");
        //   ---#########----API CALL-----#########
        waitUtils.waitForElementToBeClickable(paynowLocator);
        //    ---#########----API CALL-----#########
        waitUtils.waitForElementToBeClickable(continueLocator);
        // repeatedFunction.waitForElementToBeClickable(selectpurposeLocator);
        // GlobalLocators.BillpaymentOptn();
        //Thread.sleep(2000);
        GlobalLocators.Keyboardkey1(); // Click 1 from keyboard
        System.out.println("Sending Rs 1 to " + configReader.getIBAN());
        GlobalLocators.proceedtopayBtn();
        //    ---#########----API CALL-----#########
        waitUtils.waitForElementToBeClickable(paynowLocator);
        Thread.sleep(3000);
        GlobalLocators.amountsend();
        GlobalLocators.closeBtn();
    }
}
