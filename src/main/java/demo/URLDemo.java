package demo;

import environment.RunEnvironment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class URLDemo {

    public void goToUrl() {
        WebDriver driver = RunEnvironment.getWebDriver();
        driver.get("http://www.google.com");
    }
}
