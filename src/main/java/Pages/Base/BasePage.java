package Pages.Base;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.net.MalformedURLException;
import java.net.URL;

public class BasePage {

    public static IOSDriver driver;

    @BeforeClass
    public static void initializeDriver() throws MalformedURLException {

        XCUITestOptions options = new XCUITestOptions();
        options.setBundleId("com.m3tech.ublnetbanking.enterprise223");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "iPhone 8 Plus");
        capabilities.setCapability("platformVersion", "16.7.7");
        capabilities.setCapability("udid", "02ad4d6dbd488a06a498398d6c9e1ced8200932f");
        capabilities.setCapability("noReset", true);
        capabilities.merge(options);

        URL url = new URL("http://0.0.0.0:4723");
        driver = new IOSDriver(url, capabilities);
        System.out.println("Application has Started...!!!");
    }

    // Getter method to access driver from other classes
    public static IOSDriver getDriver() {
        return driver;
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Session closed!");
        if (driver != null) {
            driver.quit();
        }
    }
}
