package TestCases;

import Pages.Base.BasePage;
import Pages.Login.LoginPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class TC01_Login extends BasePage { // Extending BasePage to inherit driver initialization

    @Test(priority = 1, groups = ("Regression"), description = "TC01_Verify that user should be Login Successfully")
    @Severity(SeverityLevel.BLOCKER)
    @Epic("Login")
    @Story("Login")
    public void testLogin() throws InterruptedException {
        // Initialize LoginPage and use the driver initialized in BasePage
        LoginPage loginPage = new LoginPage();
        loginPage.swipeUpFromMiddle();
        loginPage.typeLoginCredential();
        loginPage.verifyLoginIsSuccess();
    }
}
