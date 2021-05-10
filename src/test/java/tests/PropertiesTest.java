package tests;

import environment.PropertiesManager;
import environment.RunEnvironment;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class PropertiesTest {
    @Test
    public void test_getSystemProperties() {
        Properties properties = System.getProperties();
        Assert.assertNotNull(properties);
        properties.forEach((k, v) -> System.out.println("key : " + k + ", value " + v));
    }

    @Test
    public void test_getApplicationProperties() throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream("C:\\Users\\A035776\\Documents\\dev\\selenium-tutorial\\src\\main\\resources\\app.properties");
        properties.load(inputStream);
        Assert.assertNotNull(properties);
        properties.forEach((k, v) -> System.out.println("key : " + k + ", value " + v));
    }
    // test PropertiesManager
    @Test
    public void test_listProperties() throws IOException {
        Properties properties = PropertiesManager.getProperties();
        properties.forEach((k, v) -> {
            System.out.println("key : " + k + ", value " + v);
        });
    }

    @Test
    public void test_getPropertyValueUsingKeyString() throws IOException {
        String key = "webdriver.chrome.driver";
        String actual = PropertiesManager.getValue(key);;
        String expected = "C:\\Users\\A035776\\Documents\\Development\\AMICA Dev\\Selenium\\SeleniumWebDriver\\chromedriver.exe";
        String msg = "Mismatch ";
        assertEquals(msg, expected, actual);
    }
}
