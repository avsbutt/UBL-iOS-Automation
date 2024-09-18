package Locators;
import org.openqa.selenium.By;
import static Pages.Base.BasePage.driver;

public class GlobalLocators {
    public static By continueBtn() { return By.xpath("//XCUIElementTypeStaticText[@name='Continue']"); }
    public static By textField() { return By.xpath("//XCUIElementTypeTextField"); }
    public static By closeBtn() { return By.xpath("//XCUIElementTypeButton[@name=\"close\"]"); }
    public static void getstartedBtn() { driver.findElement(new By.ByXPath("//XCUIElementTypeStaticText[@name=\"Get Started\"]")).click(); }
    public static By paynowBtn() { return By.xpath("//XCUIElementTypeStaticText[@name='Pay Now']"); }
    public static By paymentsMenu(){ return By.xpath("//XCUIElementTypeStaticText[@name=\"\u200EPayments\"]"); }
    public static By selectpurpose() { return By.xpath("//XCUIElementTypeStaticText[@name=\"Select Purpose\"]"); }
    public static void BillpaymentOptn() { driver.findElement(new By.ByXPath("//XCUIElementTypeStaticText[@name=\"Bill Payment\"]")).click(); }

    public static By payanyoneMenu(){ return By.xpath("//XCUIElementTypeStaticText[@name=\"\u200EPay Anyone\"]"); }
    public static By otpkeyboard(){ return By.xpath("//XCUIElementTypeOther[@name=\"suggestion\"]"); }
    public static void Keyboardkey1() { driver.findElement(new By.ByXPath("//XCUIElementTypeKey[@name=\"1\"]")).click(); }
    public static By backBtn() { return By.xpath("//XCUIElementTypeButton[@name=\"back\"]"); }

    public static By alert() { return By.xpath("//XCUIElementTypeStaticText[@name=\"Alert!\"]"); }



    public static void proceedtopayBtn() { driver.findElement(new By.ByXPath("//XCUIElementTypeStaticText[@name=\"Proceed to Pay\"]")).click(); }
    public static void amountsend() {
        if (driver.findElement(new By.ByXPath("//XCUIElementTypeStaticText[@name=\"Amount Sent\"]")).isDisplayed()) {
            System.out.println("Amount is Send, Payment Successful");
        } else System.out.println("Transaction Failed");
    }

}