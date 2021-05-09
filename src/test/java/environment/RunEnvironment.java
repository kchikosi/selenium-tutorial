package environment;

import org.openqa.selenium.WebDriver;

public class RunEnvironment {
    public static void setWebDriver(WebDriver driver) {
        RunEnvironment.webDriver = driver;
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public WebDriver getDriver() {
        return webDriver;
    }

    private static WebDriver webDriver;

}
