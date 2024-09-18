package TestCases;

import Pages.Base.BasePage;
import Pages.Payments.PayAnyone.AddIbanPayee;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class TC02_PayAnyone_AddIbanPayee extends BasePage {
    @Test(priority = 1, description = "TC02_Verify that user can add a new payee")
    @Severity(SeverityLevel.BLOCKER)
    @Epic("PayAnyone")
    @Story("Add IBAN Payee")
    public void testAddNewPayee() throws InterruptedException {
        // Initialize LoginPage and use the driver initialized in BasePage
        AddIbanPayee addIbanPayee = new AddIbanPayee();
        addIbanPayee.addNewIbanInPayee();
    }
}
