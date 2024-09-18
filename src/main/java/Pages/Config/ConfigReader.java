package Pages.Config;
import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class ConfigReader {

    IOSDriver driver;
    public static ConfigReader configReader;
    public ConfigReader(IOSDriver driver){
        this.driver = driver;
        configReader = new ConfigReader("src/main/resources/config.properties");
    }

    private Properties properties;
    public ConfigReader(String s) {
        properties = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new RuntimeException("Could not load config.properties");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getUsername() { return properties.getProperty("username"); }
    public String getPassword() {
        return properties.getProperty("password");
    }
    public String getName() {
        return properties.getProperty("name");
    }
    public String getMobileNo() {
        return properties.getProperty("mobileno");
    }
    public String getCnic() {
        return properties.getProperty("cnic");
    }
    public String getIBAN() { return properties.getProperty("IBAN"); }
}
