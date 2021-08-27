package environment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EnvironmentManager {

    public static void initWebDriver() throws IOException {
        String chromeDriver = "webdriver.chrome.driver";
        System.setProperty(chromeDriver, PropertiesManager.getValue(chromeDriver));
        WebDriver driver = new ChromeDriver(chromeOptions());
        RunEnvironment.setWebDriver(driver);
    }

    private static ChromeOptions chromeOptions() throws IOException {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", PropertiesManager.getValue("chrome.credentials.enable.service"));
        prefs.put("profile.password_manager_enabled", PropertiesManager.getValue("chrome.profile.password.manager.enabled"));
        options.addArguments("disable-extensions");
        options.addArguments("--start-maximized");
        options.setExperimentalOption("prefs", prefs);
        return options;
    }

    public static void shutDownDriver() {
        RunEnvironment.getWebDriver().quit();
    }

}
