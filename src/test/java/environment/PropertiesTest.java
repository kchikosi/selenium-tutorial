package environment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class PropertiesTest {
    private static final Logger logger = LogManager.getLogger(PropertiesTest.class);

    @Test
    public void test_getSystemProperties() {
        Properties properties = System.getProperties();
        Assert.assertNotNull(properties);
        properties.forEach((k, v) -> logger.info("key : " + k + ", value " + v));
    }

    @Test
    public void test_loadApplicationProperties() throws IOException {
        Properties properties = new Properties();
        ClassLoader classLoader = PropertiesManager.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("config.properties");
        properties.load(inputStream);
        inputStream.close();
        Assert.assertNotNull(properties);
        properties.forEach((k, v) -> logger.info("key : " + k + ", value " + v));
    }

    @Test
    public void test_propertiesCount() throws IOException {
        Properties properties = PropertiesManager.getProperties();
        properties.forEach((k, v) -> logger.info("key : " + k + ", value " + v));
        assertEquals("Count mismatch : ", 4, properties.size());
    }

    @Test
    public void test_getPropertyValueUsingKeyString() throws IOException {
        String key = "webdriver.chrome.driver";
        String actual = PropertiesManager.getValue(key);
        String expected = "C:\\Users\\A035776\\Documents\\Development\\AMICA Dev\\Selenium\\SeleniumWebDriver\\chrome\\version\\92\\chromedriver.exe";
        String msg = "String mismatch : ";
        assertEquals(msg, expected, actual);
    }
}
