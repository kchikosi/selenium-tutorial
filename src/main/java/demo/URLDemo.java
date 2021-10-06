package demo;

import environment.RunEnvironment;
import org.openqa.selenium.WebDriver;

public class URLDemo {

    public void goToUrl() {
        WebDriver driver = RunEnvironment.getWebDriver();
        driver.get("http://www.google.com");
    }
}
