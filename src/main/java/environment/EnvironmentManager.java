package environment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class EnvironmentManager {
    public static void initWebDriver() throws IOException {
        String chromeDriver = "webdriver.chrome.driver";
        System.setProperty(chromeDriver, PropertiesManager.getValue(chromeDriver));
        WebDriver driver = new ChromeDriver();
        RunEnvironment.setWebDriver(driver);
    }

    public static void shutDownDriver() {
        RunEnvironment.getWebDriver().quit();
    }

}
